package edu.uncc.assignment06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import edu.uncc.assignment06.databinding.FragmentUsersBinding;
import edu.uncc.assignment06.databinding.ListItemUserBinding;
import edu.uncc.assignment06.models.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UsersFragment extends Fragment {
    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    FragmentUsersBinding binding;
    ArrayList<User> mUsers = new ArrayList<>();
    UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Users");

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter();
        binding.recyclerView.setAdapter(adapter);
        getUsers();
    }

    private final OkHttpClient client = new OkHttpClient();
    private void getUsers(){
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/mood/users")
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
                    Log.d("demo", "onResponse: " + body);
                    mUsers.clear();

                    try {
                        JSONObject jsonObject = new JSONObject(body);
                        JSONArray usersJsonArray = jsonObject.getJSONArray("users");

                        for (int i = 0; i < usersJsonArray.length(); i++) {
                            JSONObject userJsonObject = usersJsonArray.getJSONObject(i);
                            User user = new User(userJsonObject);
                            mUsers.add(user);
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                        
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    Log.d("demo", "onResponse: not successful");
                }
            }
        });
    }

    private void deleteUser(String uid){
    //get "posting form parameters" from okhttp
        RequestBody formBody = new FormBody.Builder()
                .add("uid", uid)
                .build();
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/mood/delete-user")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getUsers();
                        }
                    });
                }else{

                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_new_user_action) {
            Log.d("demo", "onOptionsItemSelected: menu item clicked");
            mListener.gotoAddUser();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu); //Inflate the menu
    }

    UsersListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof UsersListener) {
            mListener = (UsersListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement UsersListener");
        }
    }

    interface UsersListener{
        void gotoAddUser();
        void gotoProfile(User user);
    }


    class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder>{

        @NonNull
        @Override
        public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ListItemUserBinding userBinding = ListItemUserBinding.inflate(getLayoutInflater(), parent, false);
            return new UserHolder(userBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull UserHolder holder, int position) {
            User user = mUsers.get(position);
            holder.setupUI(user);
        }

        @Override
        public int getItemCount() {
            return mUsers.size();
        }

        class UserHolder extends RecyclerView.ViewHolder{
            ListItemUserBinding mUserBinding;
            User mUser;
            public UserHolder(ListItemUserBinding userBinding) {
                super(userBinding.getRoot());
                mUserBinding = userBinding;
            }

            public void setupUI(User user){
                mUserBinding.textViewUserAgeGroup.setText(user.getAge_group_name());
                mUserBinding.textViewUserName.setText(user.getName());
                //problem: images are HTTP, not HTTPS. add android:usesCleartextTraffic="true" to manifest
                Picasso.get().load(user.getMood_imgUrl()).into(mUserBinding.imageViewUserMood);
                mUser = user;

                mUserBinding.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteUser(user.getUid());
                    }
                });
            }
        }
    }

}