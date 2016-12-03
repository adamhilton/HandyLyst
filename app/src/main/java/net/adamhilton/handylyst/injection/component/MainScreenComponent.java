package net.adamhilton.handylyst.injection.component;

import net.adamhilton.handylyst.injection.module.MainScreenModule;
import net.adamhilton.handylyst.injection.scope.PerActivity;
import net.adamhilton.handylyst.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
