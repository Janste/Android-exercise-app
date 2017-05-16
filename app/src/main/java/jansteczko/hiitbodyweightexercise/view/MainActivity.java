package jansteczko.hiitbodyweightexercise.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jansteczko.hiitbodyweightexercise.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void beginWorkoutButtonAction(View view) {
        Intent intent = new Intent(this, BeginWorkoutActivity.class);
        startActivity(intent);
    }

    public void goToWorkoutsListAction(View view) {
        Intent intent = new Intent(this, ChooseWorkoutActivity.class);
        startActivity(intent);
    }

    public void goToAboutAction(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

}
