package net.adamhilton.handylyst.injection.module;

import android.app.Application;
import android.content.Context;

import net.adamhilton.handylyst.BuildConfig;
import net.adamhilton.handylyst.data.local.InMemoryListRepo;
import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.injection.qualifier.AppContext;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @PerApplication
    @AppContext
    Context provideAppContext() {
        return application;
    }

    @Provides
    @PerApplication
    RealmConfiguration provideRealmConfiguration() {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        if(BuildConfig.DEBUG) { builder = builder.deleteRealmIfMigrationNeeded(); }
        return builder.build();
    }

    @Provides
    Realm provideRealm(RealmConfiguration realmConfiguration) {
        return Realm.getInstance(realmConfiguration);
    }
}
