package net.adamhilton.handylyst.ui.base;

import android.support.v7.app.AppCompatActivity;

import net.adamhilton.handylyst.HandyLystApp;
import net.adamhilton.handylyst.injection.component.ActivityComponent;
import net.adamhilton.handylyst.injection.component.DaggerActivityComponent;
import net.adamhilton.handylyst.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityComponent = null;
    }
}
