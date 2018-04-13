package ru.mail.park.lecture9.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import ru.mail.park.lecture9.App;
import ru.mail.park.lecture9.R;

public class TaskSecondActivity extends AppCompatActivity {

    @Inject
    TaskSingleton taskSingleton;

    @BindView(R.id.first_input)
    EditText firstInput;

    @BindView(R.id.second_input)
    EditText secondInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_second);

        App.getComponent().inject(this);
        ButterKnife.bind(this);

        firstInput.setText(taskSingleton.getFirstText());
        secondInput.setText(taskSingleton.getSecondText());
    }

    @OnTextChanged(R.id.first_input)
    void onFirstInputChanged(final CharSequence text) {
        taskSingleton.setFirstText(text.toString());
    }

    @OnTextChanged(R.id.second_input)
    void onSecondInputChanged(final CharSequence text) {
        taskSingleton.setSecondText(text.toString());
    }

    @OnClick(R.id.open_first_view)
    public void onLaunchFirstTaskClick() {
        final Intent intent = new Intent(this, TaskFirstActivity.class);
        startActivity(intent);
    }
}
