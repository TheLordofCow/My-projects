package edu.uncc.assignment07;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import edu.uncc.assignment07.databinding.FragmentLoginBinding;
import edu.uncc.assignment07.models.AuthResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginFragment extends Fragment {
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editTextEmail.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getActivity(), "Enter valid email!", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()){
                    Toast.makeText(getActivity(), "Enter valid password!", Toast.LENGTH_SHORT).show();
                } else {
                    login(email, password);
                }
            }
        });

        binding.buttonCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.createNewAccount();
            }
        });

        getActivity().setTitle(R.string.login_label);
    }

    LoginListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (LoginListener) context;
    }

    private final OkHttpClient client = new OkHttpClient();
    void login(String email, String password){
        RequestBody formBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/posts/login")
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
                    getActivity().runOnUiThread(new Runnable(){
                        @Override
                        public void run() {

                            try{
                                JSONObject json = new JSONObject(body);
                                String stat = json.getString("status");

                                if (stat.equals("ok")) {
                                    Log.d("demo", "Success 2");
                                    AuthResponse auth = new AuthResponse(json);
                                    //SharedPreferences sharedPref = getActivity().getSharedPreferences("my_app_prefs", Context.MODE_PRIVATE);
                                    mListener.authCompleted(auth);
                                }
                            }catch(JSONException e){
                                throw new RuntimeException(e);
                            }
                        }
                    });
                } else{
                    Log.d("demo", "failure 2");
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

    interface LoginListener {
        void createNewAccount();
        void authCompleted(AuthResponse authResponse);
    }
}