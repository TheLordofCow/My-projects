package edu.uncc.assessment02;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.assessment02.databinding.FragmentAddUserBinding;
import edu.uncc.assessment02.models.State;

public class AddUserFragment extends Fragment {

    AddListener listen;
    State state;
    private static final String p1 = "param1";
    private static final String p2 = "param2";
    private static final String p3 = "param3";
    private static String name;
    private static int age;
    private static int credit;
    FragmentAddUserBinding binding;

    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance(State state) {
        AddUserFragment fragment = new AddUserFragment();
        Bundle args = new Bundle();
        args.putSerializable(p1, state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getSerializable(p1) != null) {
            state = (State) getArguments().getSerializable(p1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);

        if (name != null) {
            binding.editTextName.setText(name);
        }
        if(age != 0){
            binding.editTextAge.setText(age+"");
        }
        if(credit != 0){
            binding.editTextCreditScore.setText(credit+"");
        }
        if(state != null){
            binding.textViewState.setText(state.getName() + ", " + state.getAbbreviation());
        }

        binding.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.editTextName.getText().toString();
                if(!binding.editTextAge.getText().toString().equals("")){
                    age = Integer.valueOf(binding.editTextAge.getText().toString());
                }
                if(!binding.editTextCreditScore.getText().toString().equals("")) {
                    credit = Integer.valueOf(binding.editTextCreditScore.getText().toString());
                }
                listen.gotoState();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editTextName.getText().toString().equals("")){
                    Toast.makeText(getContext(), "enter name", Toast.LENGTH_SHORT).show();
                }else{
                    name = binding.editTextName.getText().toString();

                    if(binding.editTextAge.getText().toString().equals("")){
                        Toast.makeText(getContext(), "enter age", Toast.LENGTH_SHORT).show();
                    }else{
                        age = Integer.valueOf(binding.editTextAge.getText().toString());

                        if(binding.editTextCreditScore.getText().toString().equals("")) {
                            Toast.makeText(getContext(), "enter credit score ", Toast.LENGTH_SHORT).show();
                        } else{
                            credit = Integer.valueOf(binding.editTextCreditScore.getText().toString());
                            if(credit < 300 || credit > 800){
                                Toast.makeText(getContext(), "enter credit score above 300 and less than 800", Toast.LENGTH_SHORT).show();
                            }
                            else if(state == null){
                                Toast.makeText(getContext(), "Select a state", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                listen.submitUser(name, age, credit, state);
                            }
                        }
                    }
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Add User");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof AddListener){
            listen = (AddListener) context;
        }else{
            throw new RuntimeException(context.toString()+ " implement AddListener");
        }
    }
    public interface AddListener{
        void gotoState();
        void submitUser(String name, int age, int credit, State state);
    }
}