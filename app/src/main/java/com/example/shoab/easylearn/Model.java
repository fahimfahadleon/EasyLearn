package com.example.shoab.easylearn;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Model implements Serializable {
    private int id;
    private String name;
    private String type;
    private String description;
    private String solution;

    public Model(int id, String name, String type, String description, String solution) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.solution = solution;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSolution() {
        return solution;
    }

    @NonNull
    @Override
    public String toString() {
        return getName()+" "+ getDescription() +" "+ getSolution() +" "+ getType() +" "+ getId();
    }
}
