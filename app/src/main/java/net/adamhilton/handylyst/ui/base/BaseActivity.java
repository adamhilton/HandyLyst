package net.adamhilton.handylyst.ui.base;

import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.realm.Realm;

public class BaseActivity extends AppCompatActivity {

    @Inject Realm realm;

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(realm != null) { realm.close(); }
        realm = null;
    }
}
