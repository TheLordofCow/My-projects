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

import java.util.ArrayList;

public class UsersFragment extends Fragment {
    public UsersFragment() {
        // Required empty public constructor
    }
    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ArrayList<User> users = listen.setUserList();
        UserAdapter adapter;
        ListView userList = view.findViewById(R.id.userList);
        adapter = new UserAdapter(view.getContext(), R.layout.list_item_user, users);
        userList.setAdapter(adapter);

        view.findViewById(R.id.buttonClearAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.clear();
                adapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.buttonAddNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listen.gotoAddUser();
            }
        });

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = users.get(i);
                listen.gotoProfile(user.getName(), user.getAge(), user.getfValue());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Users");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof userListener){
            listen = (userListener) context;
        } else{
            throw new RuntimeException(context.toString() + "Must implement userListener");
        }
    }

    userListener listen;
    public interface userListener{
        void gotoAddUser();
        void clear();
        ArrayList setUserList();
        void gotoProfile(String name, String age, String fValue);
    }
}