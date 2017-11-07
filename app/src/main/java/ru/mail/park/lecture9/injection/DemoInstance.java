package ru.mail.park.lecture9.injection;

import android.util.Log;

public class DemoInstance {
    public DemoInstance(final StringUtils stringUtils) {
        Log.d("DAGGER", "Demo instance has been created");
        Log.d("DAGGER", stringUtils.getAppName());
    }
}
