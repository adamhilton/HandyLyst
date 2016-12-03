package net.adamhilton.handylyst.injection.module;

import net.adamhilton.handylyst.injection.scope.PerActivity;
import net.adamhilton.handylyst.ui.main.MainScreenContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenModule {

    private MainScreenContract.View view;

    public MainScreenModule(MainScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    public MainScreenContract.View provideMainScreenView() {
        return view;
    }

}
