package ru.mail.park.lecture9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import ru.mail.park.lecture9.injection.DemoInstance;
import ru.mail.park.lecture9.injection.DemoSingleton;

public class ButterActivity extends AppCompatActivity {

    @Inject
    DemoSingleton singleton;

    @Inject
    DemoInstance instance;

    @BindString(R.string.toast)
    String message;

    @BindDimen(R.dimen.demo_dimen)
    int tenDp;

    @BindView(R.id.dp_to_px)
    TextView dpToPx;

    @BindView(R.id.text_length)
    TextView textLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        App.getComponent().inject(this);
        ButterKnife.bind(this);

        dpToPx.setText(getString(R.string.dp_to_px, 10, tenDp));
    }

    @OnClick(R.id.show_toast)
    void onShowToastClick() {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @OnTextChanged(R.id.input)
    void onInputChanged(final CharSequence text) {
        textLength.setText(String.valueOf(text.length()));
    }
}
