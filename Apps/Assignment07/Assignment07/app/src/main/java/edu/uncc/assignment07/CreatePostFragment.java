package edu.uncc.assignment07;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import edu.uncc.assignment07.databinding.FragmentCreatePostBinding;
import edu.uncc.assignment07.models.AuthResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreatePostFragment extends Fragment {
    public CreatePostFragment() {
        // Required empty public constructor
    }

    private static final String p1 = "p1";
    private static AuthResponse auth;
    FragmentCreatePostBinding binding;

    public static CreatePostFragment newInstance(AuthResponse auth) {
        Bundle args = new Bundle();
        args.putSerializable(p1, auth);
        CreatePostFragment fragment = new CreatePostFragment();
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
        binding = FragmentCreatePostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goBackToPosts();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postText = binding.editTextPostText.getText().toString();
                if(postText.isEmpty()){
                    Toast.makeText(getActivity(), "Enter valid post !!", Toast.LENGTH_SHORT).show();
                } else {
                    createPost(postText);
                }
            }
        });
        getActivity().setTitle(R.string.create_post_label);
    }

    private final OkHttpClient client = new OkHttpClient();
    void createPost(String post_text){
        RequestBody formBody = new FormBody.Builder()
                .add("post_text", post_text)
                .build();
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/posts/create")
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
                    Log.d("Create Post", "Success");
                    mListener.goBackToPosts();
                } else{
                    Log.d("Create Post", "failure");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json = new JSONObject(body);
                                String message = json.getString("message");
                                Log.d("Create Post", message);
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

    CreatePostListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (CreatePostListener) context;
    }

    interface CreatePostListener {
        void goBackToPosts();
    }
}