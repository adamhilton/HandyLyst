package net.adamhilton.handylyst.data.model;

import net.adamhilton.handylyst.util.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import io.realm.ListRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@Parcel(implementations = {ListRealmProxy.class},
        value = Parcel.Serialization.FIELD,
        analyze = { List.class })
public class List extends RealmObject{

    @PrimaryKey
    public int Id;
    public String Name;
    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<RealmString> Items = new RealmList<>();
//
//    public String getName() {
//        if (Name == null || Name.isEmpty()) {
//            setName("No name set");
//        }
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public java.util.List<String> getItems() {
//        return Arrays.asList(Items.toString());
//    }
//
//    public void addItem(String item) {
//        RealmString realmString = new RealmString();
//        realmString.value = item;
//        this.Items.add(realmString);
//    }
//
//    public void removeItem(int index) {
//        this.Items.remove(index);
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public void setItem(int index, String text) {
//        RealmString realmString = new RealmString();
//        realmString.value  = text;
//        Items.set(index, realmString);
//    }
}
