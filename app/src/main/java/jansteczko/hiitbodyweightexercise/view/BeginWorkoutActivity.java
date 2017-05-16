package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.BeginWorkoutPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class BeginWorkoutActivity extends AppCompatActivity implements BeginWorkoutView {

    private BeginWorkoutPresenter presenter;
    private TextView currentWorkoutTextView;
    private TextView difficultyLevelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin_workout_activity);

        setTitle("Begin Workout");

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            presenter = new BeginWorkoutPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        currentWorkoutTextView = (TextView) findViewById(R.id.chosen_workout_name_text_view);
        difficultyLevelTextView = (TextView) findViewById(R.id.chosen_difficulty_level_text_view);

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
    public void onBackPressed() {
        presenter.backButtonPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public void setCurrentWorkoutTextView(String text) {
        currentWorkoutTextView.setText(text);
    }

    public void setDifficultyLevelTextView(String text) {
        difficultyLevelTextView.setText(text);
    }

    public void beginTrainingButtonAction(View view) {
        presenter.beginTrainingButtonClicked();
    }

    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void chooseWorkoutActivityButtonAction(View view) {
        presenter.chooseWorkoutActivityButtonClicked();
    }

    public void goToChooseWorkoutActivity() {
        Intent intent = new Intent(this, ChooseWorkoutActivity.class);
        startActivity(intent);
    }

    public void chooseDifficultyActivityButtonAction(View view) {
        presenter.chooseDifficultyActivityButtonClicked();
    }

    public void goToChooseDifficultyActivity() {
        Intent intent = new Intent(this, ChooseDifficultyActivity.class);
        startActivity(intent);
    }

    public void goToPrepareForWorkoutActivity() {
        Intent intent = new Intent(this, PrepareForWorkoutActivity.class);
        startActivity(intent);
    }
}