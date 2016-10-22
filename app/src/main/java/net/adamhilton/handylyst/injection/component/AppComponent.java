package net.adamhilton.handylyst.injection.component;

import android.content.Context;

import net.adamhilton.handylyst.injection.module.AppModule;
import net.adamhilton.handylyst.injection.qualifier.AppContext;
import net.adamhilton.handylyst.injection.scope.PerApplication;

import dagger.Component;

@PerApplication
@Component(modules={AppModule.class})
public interface AppComponent {
    @AppContext
    Context context();

}