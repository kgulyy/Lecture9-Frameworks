package ru.mail.park.lecture9.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.lecture9.R;

@Module
public class UtilsModule {
    @Provides
    @Singleton
    StringUtils provideStringUtils(final Context context) {
        return new StringUtils() {
            @Override
            public String getAppName() {
                return context.getString(R.string.app_name);
            }
        };
    }
}
