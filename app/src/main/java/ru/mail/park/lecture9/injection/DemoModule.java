package ru.mail.park.lecture9.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoModule {

    @Provides
    @Singleton
    DemoSingleton provideSingleton() {
        return new DemoSingleton();
    }

    @Provides
    DemoInstance provideInstance(StringUtils stringUtils) {
        return new DemoInstance(stringUtils);
    }
}
