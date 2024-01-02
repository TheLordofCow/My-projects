package edu.uncc.assignment05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements UsersFragment.UsersListener,
        AddUserFragment.addListener, SelectAgeGroupFragment.ageListener,
        SelectMoodFragment.faceListener, SortFragment.SortListener,
        FilterFragment.FilterListener, ProfileFragment.ProfileListener {

    ArrayList<User> mUsers = new ArrayList<>();
    ArrayList<Mood> moods = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moods.add(new Mood("Awful", R.drawable.not_well));
        moods.add(new Mood("Sad", R.drawable.sad));
        moods.add(new Mood("OK", R.drawable.ok));
        moods.add(new Mood("Good", R.drawable.good));
        moods.add(new Mood("Great", R.drawable.very_good));

        mUsers.add(new User("Bob Smith", "18-24 years old", moods.get(0)));
        mUsers.add(new User("Tom Green", "25-34 years old", moods.get(1)));
        mUsers.add(new User("Jerid Letto", "35-44 years old", moods.get(2)));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rootView, new UsersFragment())
                .commit();
    }

    @Override
    public void ageFilter(String age) {
        users.clear();
        for(int i = 0; i < mUsers.size(); i++){
            if(mUsers.get(i).getAge().equals(age)){
                users.add(mUsers.get(i));
            }
        }
        if(users.size() == 0){
            Toast.makeText(this, "no users in filter", Toast.LENGTH_SHORT).show();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance2("By " + age))
                .commit();
    }

    @Override
    public void nameFilter(String name) {
        users.clear();
        for(int i = 0; i < mUsers.size(); i++){
            if(mUsers.get(i).getName().equals(name)){
                users.add(mUsers.get(i));
            }
        }
        if(users.size() == 0){
            Toast.makeText(this, "no users in filter", Toast.LENGTH_SHORT).show();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance2("By " + name))
                .commit();
    }

    @Override
    public void moodFilter(String mood) {
        users.clear();
        for(int i = 0; i < mUsers.size(); i++){
            if(mUsers.get(i).getMood().getName().equals(mood)){
                users.add(mUsers.get(i));
            }
        }
        if(users.size() == 0){
            Toast.makeText(this, "no users in filter", Toast.LENGTH_SHORT).show();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance2("By " + mood))
                .commit();
    }

    @Override
    public void removeFilter() {
        users.clear();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance2("No Filter"))
                .commit();
    }

    @Override
    public ArrayList setUserList() {
        if(users.size() != 0){
            return users;
        }
        return mUsers;
    }

    @Override
    public ArrayList setUserListFilter() {
        return mUsers;
    }

    @Override
    public void clear() {
        users.clear();
        mUsers.clear();
    }

    @Override
    public void gotoAddUser() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment())
                .commit();
    }

    @Override
    public void moodSubmit(String fValue) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment().newInstance2(fValue))
                .commit();
    }

    @Override
    public void gotoSort() {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.rootView, new SortFragment())
                .commit();
    }

    @Override
    public void gotoFilter() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new FilterFragment())
                .commit();
    }

    @Override
    public void gotoProf(int i) {
        if(users.size() != 0){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rootView, new ProfileFragment().newInstance(users.get(i)))
                    .commit();
        }else{
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new ProfileFragment().newInstance(mUsers.get(i)))
                .commit();
        }
    }

    @Override
    public void addUser(String name, String age, String fValue) {
        Mood mood = moods.get(Integer.valueOf(fValue));
        mUsers.add(new User(name, age, mood));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment())
                .commit();
    }

    @Override
    public void gotoAgeSelect() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectAgeGroupFragment())
                .commit();
    }

    @Override
    public void gotoMoodSelect() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectMoodFragment())
                .commit();
    }
    @Override
    public void ageSubmit(String age) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new AddUserFragment().newInstance(age))
                .commit();
    }

    @Override
    public void sortNameAsc() {
        Collections.sort(mUsers, User.nameCompareAsc);
        Collections.sort(users, User.nameCompareAsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By name Ascending"))
                .commit();
    }

    @Override
    public void sortNameDsc() {
        Collections.sort(mUsers, User.nameCompareDsc);
        Collections.sort(users, User.nameCompareDsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By name Descending"))
                .commit();
    }

    @Override
    public void sortAgeAsc() {
        Collections.sort(mUsers, User.ageCompareAsc);
        Collections.sort(users, User.ageCompareAsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By age Ascending"))
                .commit();
    }

    @Override
    public void sortAgeDsc() {
        Collections.sort(mUsers, User.ageCompareDsc);
        Collections.sort(users, User.ageCompareDsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By age Descending"))
                .commit();
    }

    @Override
    public void sortMoodAsc() {
        Collections.sort(mUsers, User.feelingCompareAsc);
        Collections.sort(users, User.feelingCompareAsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By mood Ascending"))
                .commit();
    }

    @Override
    public void sortMoodDsc() {
        Collections.sort(mUsers, User.feelingCompareDsc);
        Collections.sort(users, User.feelingCompareDsc);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment().newInstance("By mood Descending"))
                .commit();
    }

    @Override
    public void gotoUsers() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new UsersFragment())
                .commit();
    }
}