package net.adamhilton.handylyst.data.local;

import android.support.annotation.NonNull;

import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.data.model.RealmString;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.inject.Inject;

@PerApplication
public class InMemoryListRepo implements ListRepo {

    private static java.util.List<List> lists = new ArrayList<>();

    @Inject
    public InMemoryListRepo() {
        for (int i = 0; i < 5; i++) {
            String name = String.format("List # %s", i);
            create(generateList(name));
        }
    }

    @Override
    @NonNull
    public java.util.List<List> getAll() {
        return lists;
    }

    @Override
    public List getById(int id) {
        for (List item : lists) {
            if (item.Id == id) {
                return item;
            }
        }
        throw new InvalidParameterException("Invalid id");
    }

    @Override
    public void create(List list) {
        list.Id = getNewId();
        lists.add(list);
    }

    @Override
    public void update(List list) {
        int index = lists.indexOf(getById(list.Id));
        lists.set(index, list);
    }

    @Override
    public void delete(List list) {
        lists.remove(list);
    }

    private int getNewId() {
        int maxId = 0;
        if(lists.size() > 0) {
            java.util.List<Integer> ids = new ArrayList<>();
            for (List item : lists) {
                ids.add(item.Id);
            }
            maxId = Collections.max(ids);
        }
        return maxId + 1;
    }

    private List generateList(String name) {
        List list = new List();
        list.Name = name;
        java.util.List<String> items = Arrays.asList("Feed the dog", "Eat breakfast", "Write some code");
        for (String item: items) {
            list.Items.add(RealmString.valueOf(item));
        }
        return list;
    }
}