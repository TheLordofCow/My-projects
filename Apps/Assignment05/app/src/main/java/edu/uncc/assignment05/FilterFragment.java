package edu.uncc.assignment05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class FilterFragment extends Fragment {
    ArrayList<User> users;
    String[] ageGroups = {"12 years old or younger", "12-17 years old", "18-24 years old", "25-34 years old", "35-44 years old", "45-54 years old", "55-64 years old", "65-74 years old", "75 years or older"};

    String[] moods = {"Awful", "Sad", "OK", "Good", "Great"};
    FilterListener listen;
    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        users = listen.setUserListFilter();
        String[] names = new String[users.size()];

        for(int i = 0; i < users.size(); i++){
            names[i] = users.get(i).getName();
        }

        ListView ageList = view.findViewById(R.id.ageList);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, ageGroups);
        ageList.setAdapter(adapter);

        ListView nameList = view.findViewById(R.id.nameList);
        ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, names);
        nameList.setAdapter(adapter2);

        ListView moodList = view.findViewById(R.id.moodList);
        ArrayAdapter<String> adapter3;
        adapter3 = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, moods);
        moodList.setAdapter(adapter3);

        ageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.ageFilter(ageGroups[i]);
            }
        });

        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.nameFilter(names[i]);
            }
        });

        moodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.moodFilter(moods[i]);
            }
        });

        view.findViewById(R.id.buttonClearFilter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.removeFilter();
            }
        });

        return view;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof UsersFragment.UsersListener){
            listen = (FilterListener) context;
        }else{
            throw new RuntimeException(context.toString() + "Must implement FilterListener");
        }
    }

    public interface FilterListener{
        void ageFilter(String age);
        void nameFilter(String name);
        void moodFilter(String mood);
        void removeFilter();
        ArrayList setUserListFilter();
    }
}