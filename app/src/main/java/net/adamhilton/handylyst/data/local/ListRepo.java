package net.adamhilton.handylyst.data.local;

import android.support.annotation.NonNull;

import net.adamhilton.handylyst.data.model.List;

import java.util.ArrayList;
import java.util.Arrays;

public class ListRepo implements  ListRepoContract {

    private static ListRepo instance = null;
    private static java.util.List<List> lists = null;

    public static ListRepo getInstance() {
        if(instance == null) {
            instance = new ListRepo();
        }
        return instance;
    }

    protected ListRepo() {
        lists = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = String.format("List # %s", i);
            lists.add(generateList(name));
        }
    }

    @Override
    @NonNull
    public java.util.List<List> getAll() {
        return lists;
    }

    @Override
    public void create(List list) {
        lists.add(list);
    }

    private List generateList(String name) {
        net.adamhilton.handylyst.data.model.List list = new List();
        list.setName(name);
        java.util.List<String> items = Arrays.asList("Feed the dog", "Eat breakfast", "Write some code");
        list.setItems(items);
        return list;
    }
}