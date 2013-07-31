package org.wurdum.models;

import com.github.jmkgreen.morphia.annotations.Entity;

@Entity("books")
public class Book extends AbstractEntity {

    private String name;
    private int length;

    public Book() { }

    public Book(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
