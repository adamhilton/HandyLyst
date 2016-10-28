package net.adamhilton.handylyst.data.local;

import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.injection.scope.PerApplication;

@PerApplication
public class RealmListRepo implements ListRepo {

    @Override
    public java.util.List<List> getAll() {
        return null;
    }

    @Override
    public List getById(int id) {
        return null;
    }

    @Override
    public void create(List list) {

    }

    @Override
    public void update(List list) {

    }

    @Override
    public void delete(List list) {

    }
}
