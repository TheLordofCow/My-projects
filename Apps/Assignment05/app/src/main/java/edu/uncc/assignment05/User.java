package edu.uncc.assignment05;

import java.io.Serializable;
import java.util.Comparator;

public class User implements Serializable {
    String name;
    String age;
    Mood mood;

    public User() {
    }

    public User(String name, String ageGroup, Mood mood) {
        this.name = name;
        this.age = ageGroup;
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public static Comparator<User> nameCompareAsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {

            String user1 = s1.name.toLowerCase();
            String user2 = s2.name.toLowerCase();

            return user1.compareTo(user2);
        }
    };

    public static Comparator<User> nameCompareDsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {

            String user1 = s1.name.toLowerCase();
            String user2 = s2.name.toLowerCase();

            return user2.compareTo(user1);
        }
    };

    public static Comparator<User> ageCompareAsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {

            String user1 = s1.age.toLowerCase();
            String user2 = s2.age.toLowerCase();

            return user1.compareTo(user2);
        }
    };

    public static Comparator<User> ageCompareDsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {

            String user1 = s1.age.toLowerCase();
            String user2 = s2.age.toLowerCase();

            return user2.compareTo(user1);
        }
    };

    public static Comparator<User> feelingCompareAsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {
            int user1;
            int user2;
            if(s1.mood.getName().equals("Awful")){
                user1 = 0;
            } else if (s1.mood.getName().equals("Sad")) {
                user1 = 1;
            } else if (s1.mood.getName().equals("OK")) {
                user1 = 2;
            } else if (s1.mood.getName().equals("Good")) {
                user1 = 3;
            } else if (s1.mood.getName().equals("Great")) {
                user1 = 4;
            } else{
                throw new RuntimeException(s1.mood.getName());
            }

            if(s2.mood.getName().equals("Awful")){
                user2 = 0;
            } else if (s2.mood.getName().equals("Sad")) {
                user2 = 1;
            } else if (s2.mood.getName().equals("OK")) {
                user2 = 2;
            } else if (s2.mood.getName().equals("Good")) {
                user2 = 3;
            } else if (s2.mood.getName().equals("Great")) {
                user2 = 4;
            } else{
                throw new RuntimeException(s2.mood.getName());
            }

            return user1 - user2;
        }
    };

    public static Comparator<User> feelingCompareDsc = new Comparator<User>() {

        @Override
        public int compare(User s1, User s2) {
            int user1;
            int user2;
            if(s1.mood.getName().equals("Awful")){
                user1 = 1;
            } else if (s1.mood.getName().equals("Sad")) {
                user1 = 2;
            } else if (s1.mood.getName().equals("OK")) {
                user1 = 3;
            } else if (s1.mood.getName().equals("Good")) {
                user1 = 4;
            } else if (s1.mood.getName().equals("Great")) {
                user1 = 5;
            } else{
                throw new RuntimeException(s1.mood.getName());
            }

            if(s2.mood.getName().equals("Awful")){
                user2 = 1;
            } else if (s2.mood.getName().equals("Sad")) {
                user2 = 2;
            } else if (s2.mood.getName().equals("OK")) {
                user2 = 3;
            } else if (s2.mood.getName().equals("Good")) {
                user2 = 4;
            } else if (s2.mood.getName().equals("Great")) {
                user2 = 5;
            } else{
                throw new RuntimeException(s2.mood.getName());
            }

            return user2 - user1;
        }
    };
}
