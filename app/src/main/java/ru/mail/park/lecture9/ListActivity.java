package ru.mail.park.lecture9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ListFragment())
                .commit();
    }
}
