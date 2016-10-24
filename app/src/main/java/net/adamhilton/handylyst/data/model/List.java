package net.adamhilton.handylyst.data.model;

import java.io.Serializable;
import java.util.ArrayList;

public class List implements Serializable{

    private int Id;
    private String Name;
    private java.util.List<String> Items = new ArrayList<>();

    public String getName() {
        if (Name == null || Name.isEmpty()) {
            setName("No name set");
        }
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public java.util.List<String> getItems() {
        return Items;
    }

    public void addItem(String item) {
        this.Items.add(item);
    }

    public void removeItem(int index) {
        this.Items.remove(index);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setItem(int index, String text) {
        Items.set(index, text);
    }
}
