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
    
}
