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
        try(Realm realm = realmProvider.get()) {
            return realm.where(List.class).findAll();
        }
    }

    @Override
    public List getById(int id) {
        try(Realm realm = realmProvider.get()) {
            return realm.where(List.class).equalTo("Id", id).findFirst();
        }
    }

    @Override
    public void create(List list) {
        try(Realm realm = realmProvider.get()) {
            realm.executeTransaction(r -> r.copyToRealmOrUpdate(list));
        }
    }

    @Override
    public void update(List list) {
        try(Realm realm = realmProvider.get()) {
            realm.executeTransaction(r -> r.copyToRealmOrUpdate(list));
        }
    }

    @Override
    public void delete(List list) {
        try(Realm realm = realmProvider.get()) {
            realm.executeTransaction(r -> list.deleteFromRealm());
        }
    }
}
