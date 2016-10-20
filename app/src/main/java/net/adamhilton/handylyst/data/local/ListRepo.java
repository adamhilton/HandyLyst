package net.adamhilton.handylyst.data.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRepo implements  ListRepoContract {

    @Override
    @NonNull
    public List<net.adamhilton.handylyst.data.model.List> getAll() {
        List<net.adamhilton.handylyst.data.model.List> lists;
        lists = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            String name = String.format("List # %s", i);
            lists.add(generateList(name));
        }
        return lists;
    }

    private net.adamhilton.handylyst.data.model.List generateList(String name) {
        net.adamhilton.handylyst.data.model.List list = new net.adamhilton.handylyst.data.model.List();
        list.Name = name;
        list.Items = Arrays.asList("Feed the dog", "Eat breakfast", "Write some code");
        return list;
    }
}