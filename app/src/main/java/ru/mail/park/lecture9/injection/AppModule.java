package ru.mail.park.lecture9.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(final Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }
}
