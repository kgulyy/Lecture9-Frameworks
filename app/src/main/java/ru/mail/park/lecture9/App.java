package ru.mail.park.lecture9;

import android.app.Application;

import ru.mail.park.lecture9.injection.AppComponent;
import ru.mail.park.lecture9.injection.AppModule;
import ru.mail.park.lecture9.injection.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
