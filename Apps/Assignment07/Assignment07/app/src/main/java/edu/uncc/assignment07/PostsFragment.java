package edu.uncc.assignment07;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import edu.uncc.assignment07.databinding.FragmentPostsBinding;
import edu.uncc.assignment07.databinding.PagingRowItemBinding;
import edu.uncc.assignment07.databinding.PostRowItemBinding;
import edu.uncc.assignment07.models.AuthResponse;
import edu.uncc.assignment07.models.Post;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostsFragment extends Fragment {
    public PostsFragment() {
        // Required empty public constructor
    }

    private static final String p1 = "p1";
    private static AuthResponse auth;
    FragmentPostsBinding binding;
    PostsAdapter postsAdapter;
    PagingAdapter pagingAdapter;
    ArrayList<Post> mPosts = new ArrayList<>();
    ArrayList<String> mPages = new ArrayList<>();
    String page = "1";

    public static PostsFragment newInstance(AuthResponse auth) {
        Bundle args = new Bundle();
        args.putSerializable(p1, auth);
        PostsFragment fragment = new PostsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.auth = (AuthResponse) getArguments().getSerializable(p1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPostsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.textViewTitle.setText("Welcome " + auth.getUser_fullname());
        binding.textViewPaging.setText("Page " + page);

        binding.buttonCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.createPost(auth);
            }
        });

        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.logout();
            }
        });

        binding.recyclerViewPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        postsAdapter = new PostsAdapter();
        binding.recyclerViewPosts.setAdapter(postsAdapter);


        binding.recyclerViewPaging.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        pagingAdapter = new PagingAdapter();
        binding.recyclerViewPaging.setAdapter(pagingAdapter);
        getPosts(page);

        getActivity().setTitle(R.string.posts_label);
    }

    class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
        @NonNull
        @Override
        public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            PostRowItemBinding binding = PostRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new PostsViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
            Post post = mPosts.get(position);
            holder.setupUI(post);
        }

        @Override
        public int getItemCount() {
            return mPosts.size();
        }

        class PostsViewHolder extends RecyclerView.ViewHolder {
            PostRowItemBinding mBinding;
            Post mPost;
            public PostsViewHolder(PostRowItemBinding binding) {
                super(binding.getRoot());
                mBinding = binding;
            }

            public void setupUI(Post post){
                mPost = post;
                Log.d("test2", mPost.toString());
                mBinding.textViewPost.setText(post.getPost_text());
                mBinding.textViewCreatedBy.setText(post.getCreated_by_name());
                mBinding.textViewCreatedAt.setText(post.getCreated_at());

                if(!post.getCreated_by_uid().equals(auth.getUser_id())){
                    mBinding.imageViewDelete.setVisibility(View.INVISIBLE);
                }
                if(post.getCreated_by_uid().equals(auth.getUser_id())){
                    mBinding.imageViewDelete.setVisibility(View.VISIBLE);
                }

                mBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deletePost(mPost.post_id);
                        Log.d("id", mPost.post_id);
                    }
                });

            }
        }
    }

    class PagingAdapter extends RecyclerView.Adapter<PagingAdapter.PagingViewHolder> {
        @NonNull
        @Override
        public PagingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            PagingRowItemBinding binding = PagingRowItemBinding.inflate(getLayoutInflater(), parent, false);
            return new PagingViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull PagingViewHolder holder, int position) {
            String page = mPages.get(position);
            holder.setupUI(page);
        }

        @Override
        public int getItemCount() {
            return mPages.size();
        }

        class PagingViewHolder extends RecyclerView.ViewHolder {
            PagingRowItemBinding mBinding;
            String mPage;
            public PagingViewHolder(PagingRowItemBinding binding) {
                super(binding.getRoot());
                mBinding = binding;
            }

            public void setupUI(String page){
                mPage = page;
                mBinding.textViewPageNumber.setText(page);

                mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPosts(mPage);
                    }
                });
            }
        }

    }

    private final OkHttpClient client = new OkHttpClient();
    void getPosts(String page){
        String baseUrl = "https://www.theappsdr.com/posts";
        String url = baseUrl + "?page=" + page;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "BEARER " + auth.getToken())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();
                Log.d("test", body);
                if(response.isSuccessful()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mPages.clear();
                                mPosts.clear();
                                JSONObject jsonObj = new JSONObject(body);
                                JSONArray jArray = jsonObj.getJSONArray("posts");

                                for (int i = 0; i < jArray.length(); i++) {
                                    JSONObject json = jArray.getJSONObject(i);
                                    Post post = new Post(json);
                                    mPosts.add(post);
                                }

                                String pageNum = jsonObj.getString("page");
                                mPages.add(pageNum);

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                            postsAdapter.notifyDataSetChanged();
                            pagingAdapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("post error ", body);
                            Toast.makeText(getContext(), body, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    void deletePost(String id){
        RequestBody formBody = new FormBody.Builder()
                .add("post_id", id)
                .build();
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/posts/delete")
                .addHeader("Authorization", "BEARER " + auth.getToken())
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();
                if(response.isSuccessful()){
                    Log.d("demo", "Success");
                    postsAdapter.notifyDataSetChanged();
                    pagingAdapter.notifyDataSetChanged();
                } else{
                    Log.d("demo", "failure");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json = new JSONObject(body);
                                String message = json.getString("message");
                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (PostsListener) context;
    }

    PostsListener mListener;
    interface PostsListener{
        void logout();
        void createPost(AuthResponse auth);
    }
}