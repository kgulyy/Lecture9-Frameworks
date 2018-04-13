package ru.mail.park.lecture9.task;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskModule {

    @Provides
    @Singleton
    TaskSingleton provideTaskSingleton() {
        return new TaskSingleton();
    }
}
