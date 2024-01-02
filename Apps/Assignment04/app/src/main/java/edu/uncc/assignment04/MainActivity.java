package edu.uncc.assignment04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UsersFragment.userListener,
        AddUserFragment.addListener, SelectAgeGroupFragment.ageListener, SelectMoodFragment.faceListener,
        ProfileFragment.profileListener
{

    ArrayList<User> mUsers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsers.add(new User("Luka", "25-34 years old", "4"));
        mUsers.add(new User("Alipheese Fateburn XVI", "18-24 years old", "3"));
    }

    @Override
    public void gotoAddUser() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new AddUserFragment()).commit();
    }

    @Override
    public void clear() {
        mUsers.clear();
    }

    @Override
    public ArrayList setUserList() {
        return mUsers;
    }

    @Override
    public void gotoProfile(String name, String age, String fValue) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new ProfileFragment().newInstance(name, age, fValue)).commit();
    }

    @Override
    public void addUser(String name, String age, String fValue) {
        mUsers.add(new User(name, age, fValue));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new UsersFragment()).commit();
    }

    @Override
    public void gotoAgeSelect() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new SelectAgeGroupFragment()).commit();
    }

    @Override
    public void gotoMoodSelect() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new SelectMoodFragment()).commit();
    }

    @Override
    public void gotoAdd() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new AddUserFragment()).commit();
    }

    @Override
    public void moodSubmit(String fValue) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new AddUserFragment().newInstance2(fValue)).commit();
    }

    @Override
    public void ageSubmit(String age) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new AddUserFragment().newInstance(age)).commit();
    }

    @Override
    public void gotoUsers() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragView, new UsersFragment()).commit();
    }
}

