package edu.uncc.assignment06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import edu.uncc.assignment06.databinding.FragmentAddUserBinding;
import edu.uncc.assignment06.models.AgeGroup;
import edu.uncc.assignment06.models.Mood;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddUserFragment extends Fragment {

    private Mood selectedMood;
    private AgeGroup selectedAgeGroup;

    public void setSelectedMood(Mood selectedMood) {
        this.selectedMood = selectedMood;
    }

    public void setSelectedAgeGroup(AgeGroup selectedAgeGroup) {
        this.selectedAgeGroup = selectedAgeGroup;
    }

    public AddUserFragment() {
        // Required empty public constructor
    }

    FragmentAddUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add User");

        if(selectedMood == null){
            binding.textViewMood.setText("N/A");
            binding.imageViewMood.setVisibility(View.INVISIBLE);
        } else {
            binding.imageViewMood.setVisibility(View.VISIBLE);
            //show the image using the Picasso library
        }

        if(selectedAgeGroup == null){
            binding.textViewAgeGroup.setText("N/A");
        } else {
            binding.textViewAgeGroup.setText(selectedAgeGroup.getName());
        }


        binding.buttonSelectAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoGetAgeGroup();
            }
        });

        binding.buttonSelectMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoGetMood();
            }
        });
    }

    private final OkHttpClient client = new OkHttpClient();
    private void addUser(String name, String agegroupid, String moodid){
        RequestBody formBody = new FormBody.Builder()
                .add("name", name)
                .add("agegroupid", agegroupid)
                .add("moodid", moodid)
                .build();
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/mood/create-user")
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
                            
                        }else{

                        }
                    }
                });

    }

    AddUserListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddUserListener) {
            mListener = (AddUserListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement AddUserListener");
        }
    }

    interface AddUserListener{
        void doneAddingUser();
        void gotoGetAgeGroup();
        void gotoGetMood();
    }
}