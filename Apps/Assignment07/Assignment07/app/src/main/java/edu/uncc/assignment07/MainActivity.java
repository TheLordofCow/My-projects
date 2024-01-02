package edu.uncc.assignment07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import edu.uncc.assignment07.models.AuthResponse;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginListener,
        SignUpFragment.SignUpListener, PostsFragment.PostsListener, CreatePostFragment.CreatePostListener {
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        if(sharedPref.getString("user_id", "").equals("")){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerView, new LoginFragment())
                    .commit();
        } else {
            AuthResponse auth = new AuthResponse(
                    sharedPref.getString("user_id", ""),
                    sharedPref.getString("user_fullname", ""),
                    sharedPref.getString("token", ""));

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerView, new PostsFragment().newInstance(auth))
                    .commit();
        }

    }

    @Override
    public void createNewAccount() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new SignUpFragment())
                .commit();
    }

    @Override
    public void authCompleted(AuthResponse auth) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user_fullname", auth.getUser_fullname());
        editor.putString("user_id", auth.getUser_id());
        editor.putString("token", auth.getToken());
        editor.apply();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new PostsFragment().newInstance(auth))
                .commit();
    }

    @Override
    public void login() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new LoginFragment())
                .commit();
    }

    @Override
    public void logout() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear().apply();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new LoginFragment())
                .commit();
    }

    @Override
    public void createPost(AuthResponse auth) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new CreatePostFragment().newInstance(auth))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goBackToPosts() {
        getSupportFragmentManager().popBackStack();
    }
}