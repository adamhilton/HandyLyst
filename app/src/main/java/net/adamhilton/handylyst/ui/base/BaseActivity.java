package net.adamhilton.handylyst.ui.base;

import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import net.adamhilton.handylyst.HandyLystApp;
import net.adamhilton.handylyst.injection.component.ActivityComponent;
import net.adamhilton.handylyst.injection.component.DaggerActivityComponent;
import net.adamhilton.handylyst.injection.module.ActivityModule;

import javax.inject.Inject;

import io.realm.Realm;

public class BaseActivity extends AppCompatActivity {

    @Inject Realm realm;

    private ActivityComponent activityComponent;

    protected final ActivityComponent activityComponent() {
        if(activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .appComponent(HandyLystApp.getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }

        return activityComponent;
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(realm != null) { realm.close(); }
        activityComponent = null;
        realm = null;
    }
}
