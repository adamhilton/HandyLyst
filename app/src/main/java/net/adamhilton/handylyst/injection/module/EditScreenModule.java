package net.adamhilton.handylyst.injection.module;

import net.adamhilton.handylyst.injection.scope.PerActivity;
import net.adamhilton.handylyst.ui.edit.EditScreenContract;

import dagger.Module;
import dagger.Provides;

@Module
public class EditScreenModule {

    private EditScreenContract.View view;

    public EditScreenModule(EditScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    public EditScreenContract.View provideEditScreenView() {
        return view;
    }

}
