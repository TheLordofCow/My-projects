package edu.uncc.assignment04;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String age;
    String fValue;

    public User(String name, String age, String fValue){
        this.name = name;
        this.age = age;
        this.fValue = fValue;
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

    public String getfValue() {
        return fValue;
    }

    public void setfValue(String fValue) {
        this.fValue = fValue;
    }

    @Override
    public String toString() {
        return name + '\n' + age;
    }
}
