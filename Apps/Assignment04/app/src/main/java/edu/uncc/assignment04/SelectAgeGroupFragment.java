package edu.uncc.assignment04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SelectAgeGroupFragment extends Fragment {
    String[] ageGroups = {"Under 12 years old", "12-17 years old", "18-24 years old", "25-34 years old", "35-44 years old", "45-54 years old", "55-64 years old", "65-74 years old", "75 years or older"};

    public SelectAgeGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_age_group, container, false);
        ListView ageList = view.findViewById(R.id.ageList);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, ageGroups);
        ageList.setAdapter(adapter);

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoAdd();
            }
        });

        ageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.ageSubmit(ageGroups[i]);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Age Group");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ageListener){
            listen = (ageListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement ageListener");
        }
    }

    ageListener listen;
    public interface ageListener{
        void gotoAdd();
        void ageSubmit(String age);
    }
}