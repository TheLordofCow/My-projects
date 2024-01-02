package edu.uncc.assessment02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.uncc.assessment02.databinding.FragmentFilterBinding;
import edu.uncc.assessment02.models.CreditCategory;

public class FilterFragment extends Fragment {
    public FilterFragment() {
        // Required empty public constructor
    }

    CreditCategory[] creditCategories = {
            new CreditCategory("Excellent", R.drawable.excellent),
            new CreditCategory("Very Good", R.drawable.very_good),
            new CreditCategory("Good", R.drawable.good),
            new CreditCategory("Fair", R.drawable.fair),
            new CreditCategory("Poor", R.drawable.poor)
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentFilterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFilterBinding.inflate(inflater, container, false);

        CreditAdapter adapter;
        adapter = new CreditAdapter(getContext(), R.layout.credit_criteria_list_item, creditCategories);
        binding.listView.setAdapter(adapter);

        binding.buttonClearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Filter");
    }
}