package net.adamhilton.handylyst.data.local;

import android.support.annotation.NonNull;

import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;

@PerApplication
public class InMemoryListRepo implements ListRepo {

    private static java.util.List<List> lists = new ArrayList<>();

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
}