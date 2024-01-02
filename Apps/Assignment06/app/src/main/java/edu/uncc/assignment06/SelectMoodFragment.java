package edu.uncc.assignment06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import edu.uncc.assignment06.databinding.FragmentSelectMoodBinding;
import edu.uncc.assignment06.models.Mood;

public class SelectMoodFragment extends Fragment {
    public SelectMoodFragment() {
        // Required empty public constructor
    }

    FragmentSelectMoodBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectMoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Mood");
        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelMoodSelection();
            }
        });

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    SelectMoodListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SelectMoodListener) {
            mListener = (SelectMoodListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SelectMoodListener");
        }
    }

    interface SelectMoodListener {
        void sendSelectedMood(Mood mood);
        void cancelMoodSelection();
    }
}