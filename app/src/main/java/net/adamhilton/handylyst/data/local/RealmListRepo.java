package net.adamhilton.handylyst.data.local;

import net.adamhilton.handylyst.data.model.List;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import javax.inject.Inject;
import javax.inject.Provider;

import io.realm.Realm;

@PerApplication
public class RealmListRepo implements ListRepo {

    private final Provider<Realm> realmProvider;

    @Inject
    public RealmListRepo(Provider<Realm> realmProvider) {
        this.realmProvider = realmProvider;
    }

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
