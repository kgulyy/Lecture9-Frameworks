package ru.mail.park.lecture9.injection;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.park.lecture9.ButterActivity;
import ru.mail.park.lecture9.ListFragment;
import ru.mail.park.lecture9.MainActivity;

@Component(modules = {AppModule.class, DemoModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);

    void inject(ButterActivity butterActivity);

    void inject(ListFragment.ViewHolder viewHolder);
}
