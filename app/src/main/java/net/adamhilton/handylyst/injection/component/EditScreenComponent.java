package net.adamhilton.handylyst.injection.component;

import net.adamhilton.handylyst.injection.module.EditScreenModule;
import net.adamhilton.handylyst.injection.scope.PerActivity;
import net.adamhilton.handylyst.ui.edit.EditActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = EditScreenModule.class)
public interface EditScreenComponent {
    void inject(EditActivity activity);
}
