package edu.uncc.assignment05;

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

import edu.uncc.assignment05.databinding.FragmentUsersBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    FragmentUsersBinding binding;
    private static final String p1 = "param1";
    private User user;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(p1, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(p1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView name = view.findViewById(R.id.textViewUserName);
        TextView age = view.findViewById(R.id.textViewUserAgeGroup);
        TextView feeling = view.findViewById(R.id.textViewUserMood);
        ImageView face = view.findViewById(R.id.imageViewMood);

        name.setText(user.getName());
        age.setText(user.getAge());
        feeling.setText(user.getMood().getName());
        face.setImageDrawable(view.getContext().getDrawable(user.getMood().getImageResourceId()));

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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ProfileListener){
            listen = (ProfileListener) context;
        } else{
            throw new RuntimeException("need to implement ProfileListener");
        }
    }

    ProfileListener listen;
    public interface ProfileListener{
        void gotoUsers();
    }
}