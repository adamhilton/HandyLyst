package net.adamhilton.handylyst.injection.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import net.adamhilton.handylyst.injection.qualifier.ActivityContext;
import net.adamhilton.handylyst.injection.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext() { return activity; }

}
