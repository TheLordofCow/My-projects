package edu.uncc.assignment05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uncc.assignment05.databinding.FragmentSortBinding;

public class SortFragment extends Fragment {


    FragmentSortBinding binding;
    SortListener listen;

    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSortBinding.inflate(inflater, container, false);

        binding.imageViewNameAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortNameAsc();
            }
        });

        binding.imageViewNameDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortNameDsc();
            }
        });

        binding.imageViewAgeAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortAgeAsc();
            }
        });

        binding.imageViewAgeDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortAgeDsc();
            }
        });

        binding.imageViewFeelingAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortMoodAsc();
            }
        });

        binding.imageViewFeelingDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.sortMoodDsc();
            }
        });
        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoUsers();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof SortListener){
            listen = (SortListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "Must implement SortListener");
        }
    }

    public interface SortListener{
        void sortNameAsc();
        void sortNameDsc();
        void sortAgeAsc();
        void sortAgeDsc();
        void sortMoodAsc();
        void sortMoodDsc();
        void gotoUsers();
    }
}