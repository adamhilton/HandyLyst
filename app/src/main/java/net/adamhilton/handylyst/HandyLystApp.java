package net.adamhilton.handylyst;

import android.app.Application;

import net.adamhilton.handylyst.data.local.ListRepo;
import net.adamhilton.handylyst.injection.component.AppComponent;
import net.adamhilton.handylyst.injection.component.DaggerAppComponent;
import net.adamhilton.handylyst.injection.module.AppModule;

import io.realm.Realm;
import timber.log.Timber;

public class HandyLystApp extends Application {

    private static HandyLystApp Instance = null;

    private static AppComponent AppComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        Instance = this;
        AppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if(BuildConfig.DEBUG) { Timber.plant(new Timber.DebugTree()); }
    }

    public static HandyLystApp getInstance() { return Instance; }

    public static AppComponent getAppComponent() { return AppComponent; }

    public static Realm getRealm() {
        return AppComponent.realm();
    }

    public static ListRepo getListRepo() { return AppComponent.listRepo(); }
}
