package net.adamhilton.handylyst.data.model;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.RealmStringRealmProxy;

@Parcel(implementations = {RealmStringRealmProxy.class},
        value = Parcel.Serialization.FIELD,
        analyze = { RealmString.class })
public class RealmString extends RealmObject{
    public String value;
}
