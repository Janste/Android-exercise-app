package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.model.Exercise;
import jansteczko.hiitbodyweightexercise.presenter.PrepareForWorkoutPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class PrepareForWorkoutActivity extends AppCompatActivity implements PrepareForWorkoutView {

    private PrepareForWorkoutPresenter presenter;
    private ImageView firstImage;
    private TextView firstText;

    private ImageView secondImage;
    private TextView secondText;

    private ImageView thirdImage;
    private TextView thirdText;

    private ImageView fourthImage;
    private TextView fourthText;

    private ImageView fifthImage;
    private TextView fifthText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prepare_for_workout_activity);

        setTitle("Get ready...");

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            presenter = new PrepareForWorkoutPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        firstText = (TextView) findViewById(R.id.firstText);
        firstImage = (ImageView) findViewById(R.id.firstImage);

        secondText = (TextView) findViewById(R.id.secondText);
        secondImage = (ImageView) findViewById(R.id.secondImage);

        thirdText = (TextView) findViewById(R.id.thirdText);
        thirdImage = (ImageView) findViewById(R.id.thirdImage);

        fourthText = (TextView) findViewById(R.id.fourthText);
        fourthImage = (ImageView) findViewById(R.id.fourthImage);

        fifthText = (TextView) findViewById(R.id.fifthText);
        fifthImage = (ImageView) findViewById(R.id.fifthImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindView(this);
        presenter.updateView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public void startWorkoutButtonAction(View view) {
        presenter.startWorkoutButtonTapped();
    }

    public void goToDoWorkoutActivity() {
        Intent intent = new Intent(this, DoWorkoutActivity.class);
        startActivity(intent);
    }

    public void showExercises(List<Exercise> list) {

        firstText.setText(list.get(0).getName());
        firstImage.setImageResource(list.get(0).getImage());

        secondText.setText(list.get(1).getName());
        secondImage.setImageResource(list.get(1).getImage());

        thirdText.setText(list.get(2).getName());
        thirdImage.setImageResource(list.get(2).getImage());

        fourthText.setText(list.get(3).getName());
        fourthImage.setImageResource(list.get(3).getImage());

        fifthText.setText(list.get(4).getName());
        fifthImage.setImageResource(list.get(4).getImage());

    }
}
