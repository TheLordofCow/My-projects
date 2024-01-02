package edu.uncc.assessment02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import edu.uncc.assessment02.models.State;
import edu.uncc.assessment02.models.User;

public class MainActivity extends AppCompatActivity implements UsersFragment.UsersListener,
        AddUserFragment.AddListener, StatesFragment.StateListener {

    ArrayList<User> mUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rootView, new UsersFragment())
                .commit();

        //TODO: For testing created some bootstrap data
        mUsers.add(new User(new State("New York", "NY"), "Bob Smith", 25, 695));
        mUsers.add(new User(new State("Nevada", "NV"), "Alice Green", 45, 370));
        mUsers.add(new User(new State("North Carolina", "NC"), "Tom Brown", 29, 760));

    }

    @Override
    public void gotoAdd() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment())
                .commit();
    }

    @Override
    public void submitState(State state) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment().newInstance(state))
                .commit();
    }

    @Override
    public void gotoFilter() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new FilterFragment())
                .commit();
    }

    @Override
    public ArrayList<User> setUsers() {
        return mUsers;
    }

    @Override
    public void gotoState() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new StatesFragment())
                .commit();
    }

    @Override
    public void submitUser(String name, int age, int credit, State state) {
        mUsers.add(new User(state, name, age, credit));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment())
                .commit();
    }

}