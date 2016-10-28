package net.adamhilton.handylyst.injection.component;

import android.content.Context;

import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.injection.module.AppModule;
import net.adamhilton.handylyst.injection.qualifier.AppContext;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import dagger.Component;
import io.realm.Realm;

@PerApplication
@Component(modules={AppModule.class})
public interface AppComponent {
    @AppContext
    Context context();

    Realm realm();

    ListRepo listRepo();
}