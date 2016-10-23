package net.adamhilton.handylyst.injection.component;

import net.adamhilton.handylyst.injection.module.ActivityModule;
import net.adamhilton.handylyst.injection.scope.PerActivity;
import net.adamhilton.handylyst.ui.edit.EditActivity;
import net.adamhilton.handylyst.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(EditActivity activity);
}