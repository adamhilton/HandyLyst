package net.adamhilton.handylyst.data.model;

public class List {

    private String Name;
    private java.util.List<String> Items;

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

    public void setItems(java.util.List<String> items) {
        Items = items;
    }
}
