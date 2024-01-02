package edu.uncc.assessment02;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.uncc.assessment02.databinding.FragmentUsersBinding;
import edu.uncc.assessment02.models.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsersFragment extends Fragment implements UserAdapter.userAdp {

    private static final String ARG_PARAM1 = "param1";
    private String filter;
    UsersListener listen;
    ArrayList<User> users;
    LinearLayoutManager layoutManager;
    UserAdapter adapter;
    FragmentUsersBinding binding;

    public UsersFragment() {
        // Required empty public constructor
    }

    public static UsersFragment newInstance(String filter) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, filter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filter = getArguments().getString(ARG_PARAM1);
        }
        //Added to setup the menu
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);

        users = listen.setUsers();

        binding.userList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        binding.userList.setLayoutManager(layoutManager);
        adapter = new UserAdapter(users, getContext(), this);
        binding.userList.setAdapter(adapter);

        binding.imageViewFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoFilter();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Users");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_new_user_action) {
            //Navigate to the AddUserFragment Fragment
            listen.gotoAdd();
            Log.d("demo", "onOptionsItemSelected: menu item clicked");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu); //Inflate the menu
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof UsersListener){
            listen = (UsersListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement UsersListener");
        }
    }

    @Override
    public void deleteUser(int i) {
        users.remove(i);
        adapter.notifyDataSetChanged();
    }

    public interface UsersListener{
        void gotoAdd();
        void gotoFilter();
        ArrayList<User> setUsers();
    }
}