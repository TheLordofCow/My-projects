package edu.uncc.assignment05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddUserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String p1 = "param1";
    private static final String p2 = "param2";
    private static final String p3 = "param3";

    // TODO: Rename and change types of parameters
    private static String name;
    private static String age;
    private static String fValue;

    public AddUserFragment() {
        // Required empty public constructor
    }
    public static AddUserFragment newInstance(String age) {
        AddUserFragment fragment = new AddUserFragment();
        Bundle args = new Bundle();
        args.putString(p2, age);
        fragment.setArguments(args);
        return fragment;
    }

    public static AddUserFragment newInstance2(String fValue) {
        AddUserFragment fragment = new AddUserFragment();
        Bundle args = new Bundle();
        args.putString(p3, fValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getString(p2) != null) {
            age = getArguments().getString(p2);
        }
        if(getArguments() != null && getArguments().getString(p3) != null){
            fValue = getArguments().getString(p3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        EditText addNameText = view.findViewById(R.id.editTextText);
        TextView addAgeGroup = view.findViewById(R.id.textViewAgeGroup);
        TextView addFeeling = view.findViewById(R.id.textViewMood);
        ImageView addFace = view.findViewById(R.id.imageViewMood);

        addNameText.setText(this.name);
        addAgeGroup.setText(this.age);


        //I hate you fValue, you cause me so much misery
        if(this.fValue == null) {
            fValue = "5";
        }
        if (!this.fValue.equals("0") && !this.fValue.equals("1") && !this.fValue.equals("2") &&
                !this.fValue.equals("3") && !this.fValue.equals("4")) {
            this.fValue = "5";
        }

        if(Integer.parseInt(fValue) == 0){
            addFace.setImageDrawable(getResources().getDrawable(R.drawable.not_well));
            addFace.setVisibility(view.VISIBLE);
            addFeeling.setText("Awful");
        }
        else if (Integer.parseInt(fValue) == 1) {
            addFace.setImageDrawable(getResources().getDrawable(R.drawable.sad));
            addFace.setVisibility(view.VISIBLE);
            addFeeling.setText("bad");
        }
        else if (Integer.parseInt(fValue) == 2) {
            addFace.setImageDrawable(getResources().getDrawable(R.drawable.ok));
            addFace.setVisibility(view.VISIBLE);
            addFeeling.setText("OK");
        }
        else if (Integer.parseInt(fValue) == 3) {
            addFace.setImageDrawable(getResources().getDrawable(R.drawable.good));
            addFace.setVisibility(view.VISIBLE);
            addFeeling.setText("Good");
        }
        else if (Integer.parseInt(fValue) == 4) {
            addFace.setImageDrawable(getResources().getDrawable(R.drawable.very_good));
            addFace.setVisibility(view.VISIBLE);
            addFeeling.setText("Great");
        }

        view.findViewById(R.id.buttonSelectAge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = addNameText.getText().toString();
                age = addAgeGroup.getText().toString();

                listen.gotoAgeSelect();
            }
        });

        view.findViewById(R.id.buttonSelectMood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = addNameText.getText().toString();
                age = addAgeGroup.getText().toString();
                listen.gotoMoodSelect();
            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = addNameText.getText().toString();
                age = addAgeGroup.getText().toString();

                if(name.equals("")){
                    Toast.makeText(getContext(), "Enter a name", Toast.LENGTH_SHORT).show();
                } else if (age.equals("")) {
                    Toast.makeText(getContext(), "Add an age group", Toast.LENGTH_SHORT).show();
                } else if (fValue == "5") {
                    Toast.makeText(getContext(), "Add a mood", Toast.LENGTH_SHORT).show();
                }else{
                    listen.addUser(name, age, fValue);
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add User");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof addListener){
            listen = (addListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement addListener");
        }
    }

    addListener listen;
    public interface addListener{
        void addUser(String name, String age, String fValue);
        void gotoAgeSelect();
        void gotoMoodSelect();
    }
}