package ru.mail.park.lecture9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.park.lecture9.injection.DemoInstance;
import ru.mail.park.lecture9.injection.DemoSingleton;
import ru.mail.park.lecture9.injection.StringUtils;

public class MainActivity extends AppCompatActivity {

    @Inject
    DemoSingleton singleton;

    @Inject
    DemoInstance instance;

    @Inject
    StringUtils stringUtils;

    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getComponent().inject(this);
        ButterKnife.bind(this);

        title.setText(stringUtils.getAppName());
    }

    @OnClick(R.id.launch_butter)
    void onLaunchButterClick() {
        final Intent intent = new Intent(this, ButterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_list)
    void onLaunchListClick() {
        final Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
