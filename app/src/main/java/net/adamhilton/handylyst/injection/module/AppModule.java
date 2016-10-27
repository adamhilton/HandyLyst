package net.adamhilton.handylyst.injection.module;

import android.app.Application;
import android.content.Context;

import net.adamhilton.handylyst.data.local.InMemoryListRepo;
import net.adamhilton.handylyst.data.local.ListRepoContract;
import net.adamhilton.handylyst.injection.qualifier.AppContext;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

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
    static ListRepoContract provideListRepo() {
        return InMemoryListRepo.getInstance();
    }
}
