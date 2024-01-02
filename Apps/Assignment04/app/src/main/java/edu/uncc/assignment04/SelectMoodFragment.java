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
import android.widget.ListView;

public class SelectMoodFragment extends Fragment {
    String[] fValue = {"0", "1", "2", "3", "4"};
    public SelectMoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_mood, container, false);
        faceAdapter adapter;
        ListView faceList = view.findViewById(R.id.faceList);
        adapter = new faceAdapter(view.getContext(), R.layout.list_item_mood, fValue);
        faceList.setAdapter(adapter);

        faceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listen.moodSubmit(fValue[i].toString());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Mood");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof faceListener){
            listen = (faceListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement faceListener");
        }
    }

    faceListener listen;
    public interface faceListener{
        void gotoAdd();
        void moodSubmit(String fValue);
    }
}