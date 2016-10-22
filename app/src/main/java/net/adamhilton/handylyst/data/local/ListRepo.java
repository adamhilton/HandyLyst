package net.adamhilton.handylyst.data.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRepo implements  ListRepoContract {

    private static ListRepo instance = null;
    private static List<net.adamhilton.handylyst.data.model.List> lists = null;

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
    public List<net.adamhilton.handylyst.data.model.List> getAll() {
        return lists;
    }

    @Override
    public void create(net.adamhilton.handylyst.data.model.List list) {
        lists.add(list);
    }

    private net.adamhilton.handylyst.data.model.List generateList(String name) {
        net.adamhilton.handylyst.data.model.List list = new net.adamhilton.handylyst.data.model.List();
        list.setName(name);
        List<String> items =  Arrays.asList("Feed the dog", "Eat breakfast", "Write some code");
        list.setItems(items);
        return list;
    }
}