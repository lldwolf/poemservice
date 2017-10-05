package com.poem.lld.model;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {

    private static final long serialVersionUID = 660056963517433734L;
    private int id;
    private String name;
    private String dynasty;
    private List<Poem> poems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public List<Poem> getPoems() {
        return poems;
    }

    public void setPoems(List<Poem> poems) {
        this.poems = poems;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.dynasty + ")";
    }
}
