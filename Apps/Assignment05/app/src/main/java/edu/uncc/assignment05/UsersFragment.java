package edu.uncc.assignment05;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import edu.uncc.assignment05.databinding.FragmentUsersBinding;
import edu.uncc.assignment05.databinding.ListItemUserBinding;

public class UsersFragment extends Fragment implements UserAdapter.userAdp{
    public UsersFragment() {
        // Required empty public constructor
    }
    FragmentUsersBinding binding;
    LinearLayoutManager layoutManager;
    ArrayList<User> users;
    UserAdapter adapter;
    private static final String p1 = "param1";
    private static final String p2 = "param2";
    static String sorted;
    static String filter;

    public static UsersFragment newInstance(String sorted) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(p1, sorted);
        fragment.setArguments(args);
        return fragment;
    }

    public static UsersFragment newInstance2(String filter) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(p2, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getString(p1) != null) {
            sorted = getArguments().getString(p1);
        }
        if(getArguments() != null && getArguments().getString(p2) != null){
            filter = getArguments().getString(p2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Users");

        users = listen.setUserList();
        binding.userList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        binding.userList.setLayoutManager(layoutManager);
        adapter = new UserAdapter(users, view.getContext(), this);
        binding.userList.setAdapter(adapter);

        if(sorted != null){
            binding.textViewSort.setText(sorted);
        }
        if(filter != null){
            binding.textViewFilter.setText(filter);
        }

        binding.buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoAddUser();
            }
        });

        binding.buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.clear();
                adapter.notifyDataSetChanged();
            }
        });

        binding.imageViewSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoSort();
            }
        });

        binding.imageViewFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoFilter();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof UsersListener){
            listen = (UsersListener) context;
        }else{
            throw new RuntimeException(context.toString() + "Must implement UsersListener");
        }
    }
    UsersListener listen;

    @Override
    public void deleteUser(int i) {
        users.remove(i);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void gotoProfile(int i) {
        listen.gotoProf(i);
    }

    public interface UsersListener{
        ArrayList setUserList();
        void clear();
        void gotoAddUser();
        void gotoSort();
        void gotoFilter();
        void gotoProf(int i);
    }
}