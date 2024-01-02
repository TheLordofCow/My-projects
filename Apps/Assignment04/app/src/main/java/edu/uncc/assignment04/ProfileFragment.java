package edu.uncc.assignment04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private static String name;

    private static String age;
    private static String fValue;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String name, String age, String fValue) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, age);
        args.putString(ARG_PARAM3, fValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
            age = getArguments().getString(ARG_PARAM2);
            fValue = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nameView = view.findViewById(R.id.textViewUserName);
        TextView ageGroup = view.findViewById(R.id.textViewUserAgeGroup);
        TextView mood = view.findViewById(R.id.textViewUserMood);
        ImageView profileFace = view.findViewById(R.id.imageViewMood);

        nameView.setText(name);
        ageGroup.setText(age);
        mood.setText(fValue + " of 4");

        if(Integer.parseInt(fValue) == 0){
            profileFace.setImageDrawable(getResources().getDrawable(R.drawable.not_well));
        }
        else if (Integer.parseInt(fValue) == 1) {
            profileFace.setImageDrawable(getResources().getDrawable(R.drawable.sad));
        }
        else if (Integer.parseInt(fValue) == 2) {
            profileFace.setImageDrawable(getResources().getDrawable(R.drawable.ok));
        }
        else if (Integer.parseInt(fValue) == 3) {
            profileFace.setImageDrawable(getResources().getDrawable(R.drawable.good));
        }
        else if (Integer.parseInt(fValue) == 4) {
            profileFace.setImageDrawable(getResources().getDrawable(R.drawable.very_good));
        }

        view.findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoUsers();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Profile");
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof profileListener){
            listen = (profileListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement profileListener");
        }
    }

    profileListener listen;
    public interface profileListener{
        void gotoUsers();
    }
}