package edu.uncc.assessment02.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class State implements Serializable {
    String name;
    String abbreviation;
    public State() {
    }

    public State(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @NonNull
    @Override
    public String toString() {
        return name + ", " + abbreviation;
    }
}
