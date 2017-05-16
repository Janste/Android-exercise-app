package jansteczko.hiitbodyweightexercise.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jansteczko.hiitbodyweightexercise.R;

public class AboutActivity extends AppCompatActivity implements AboutView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        setTitle("About this app");
    }

}
