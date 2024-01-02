package edu.uncc.assessment02;

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

import edu.uncc.assessment02.databinding.FragmentStatesBinding;
import edu.uncc.assessment02.models.State;

public class StatesFragment extends Fragment {
    private State[] states = {
            new State("Alabama", "AL"),
            new State("Alaska", "AK"),
            new State("Arizona", "AZ"),
            new State("Arkansas", "AR"),
            new State("California", "CA"),
            new State("Colorado", "CO"),
            new State("Connecticut", "CT"),
            new State("Delaware", "DE"),
            new State("Florida", "FL"),
            new State("Georgia", "GA"),
            new State("Hawaii", "HI"),
            new State("Idaho", "ID"),
            new State("Illinois", "IL"),
            new State("Indiana", "IN"),
            new State("Iowa", "IA"),
            new State("Kansas", "KS"),
            new State("Kentucky", "KY"),
            new State("Louisiana", "LA"),
            new State("Maine", "ME"),
            new State("Maryland", "MD"),
            new State("Massachusetts", "MA"),
            new State("Michigan", "MI"),
            new State("Minnesota", "MN"),
            new State("Mississippi", "MS"),
            new State("Missouri", "MO"),
            new State("Montana", "MT"),
            new State("Nebraska", "NE"),
            new State("Nevada", "NV"),
            new State("New Hampshire", "NH"),
            new State("New Jersey", "NJ"),
            new State("New Mexico", "NM"),
            new State("New York", "NY"),
            new State("North Carolina", "NC"),
            new State("North Dakota", "ND"),
            new State("Ohio", "OH"),
            new State("Oklahoma", "OK"),
            new State("Oregon", "OR"),
            new State("Pennsylvania", "PA"),
            new State("Rhode Island", "RI"),
            new State("South Carolina", "SC"),
            new State("South Dakota", "SD"),
            new State("Tennessee", "TN"),
            new State("Texas", "TX"),
            new State("Utah", "UT"),
            new State("Vermont", "VT"),
            new State("Virginia", "VA"),
            new State("Washington", "WA"),
            new State("West Virginia", "WV"),
            new State("Wisconsin", "WI"),
            new State("Wyoming", "WY")
    };
    StateListener listen;

    public StatesFragment() {
        // Required empty public constructor
    }

    FragmentStatesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStatesBinding.inflate(inflater, container, false);

        ArrayAdapter<State> adapter;
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, states);
        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.submitState(states[i]);
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoAdd();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select State");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof StateListener){
            listen = (StateListener) context;
        }else{
            throw new RuntimeException(context.toString() + "Must implement StatesListener");
        }
    }

    public interface StateListener{
        void gotoAdd();
        void submitState(State state);
    }
}