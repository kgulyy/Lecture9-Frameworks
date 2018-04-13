package ru.mail.park.lecture9.injection;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.park.lecture9.ButterActivity;
import ru.mail.park.lecture9.ListFragment;
import ru.mail.park.lecture9.MainActivity;
import ru.mail.park.lecture9.task.TaskFirstActivity;
import ru.mail.park.lecture9.task.TaskModule;
import ru.mail.park.lecture9.task.TaskSecondActivity;

@Component(modules = {AppModule.class, DemoModule.class, UtilsModule.class, TaskModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);

    void inject(ButterActivity butterActivity);

    void inject(ListFragment.ViewHolder viewHolder);

    void inject(TaskFirstActivity taskFirstActivity);

    void inject(TaskSecondActivity taskSecondActivity);
}
