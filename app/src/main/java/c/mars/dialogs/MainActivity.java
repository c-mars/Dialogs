package c.mars.dialogs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import timber.log.Timber;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Timber.plant(new Timber.DebugTree());
    }

    @OnClick(R.id.btn)
    void click(){
        AlertDialogFragment f = new AlertDialogFragment(txt);
        f.show(getFragmentManager(), "alert");
    }
}
