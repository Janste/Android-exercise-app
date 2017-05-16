package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.ChooseDifficultyPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class ChooseDifficultyActivity extends AppCompatActivity implements ChooseDifficultyView {

    private ChooseDifficultyPresenter presenter;
    private Spinner difficultySpinner;
    private TextView workoutTimeTextView;
    private TextView breakTimeTextView;
    private TextView exercisesPerRoundTextView;
    private TextView roundsTextView;
    private TextView totalTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_workout_difficulty_activty);
        setTitle("Choose difficulty");

        if (savedInstanceState == null) {
            presenter = new ChooseDifficultyPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        difficultySpinner = (Spinner) findViewById(R.id.choose_difficulty_level_spinner);
        workoutTimeTextView = (TextView) findViewById(R.id.workout_time);
        breakTimeTextView = (TextView) findViewById(R.id.break_time);
        exercisesPerRoundTextView = (TextView) findViewById(R.id.exercises_per_round);
        roundsTextView = (TextView) findViewById(R.id.rounds);
        totalTimeTextView = (TextView) findViewById(R.id.total_time);
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
        return this.getApplicationContext();
    }

    public void initializeSpinners(List<String> levels, String currentLevel) {

        ArrayAdapter<String> difficultyLevelsArrayAdapter = new ArrayAdapter<>(ChooseDifficultyActivity.this, R.layout.spinner_item, levels);
        difficultyLevelsArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyLevelsArrayAdapter);

        difficultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String text = difficultySpinner.getSelectedItem().toString();
                presenter.difficultyLevelSelected(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        difficultySpinner.setSelection(getIndex(difficultySpinner, currentLevel));

    }

    public void setWorkoutTimeTextView(String time) {
        String seconds = getString(R.string.seconds);
        String text = time + " " + seconds;
        workoutTimeTextView.setText(text);
    }

    public void setBreakTimeTextView(String time) {
        String seconds = getString(R.string.seconds);
        String text = time + " " + seconds;
        breakTimeTextView.setText(text);
    }

    public void setExercisesPerRoundTextView(String text) {
        exercisesPerRoundTextView.setText(text);
    }

    public void setRoundsTimeTextView(String text) {
        roundsTextView.setText(text);
    }

    public void setTotalTimeTextView(String time) {
        String seconds = getString(R.string.minutes);
        String text = time + " " + seconds;
        totalTimeTextView.setText(text);
    }

    private int getIndex(Spinner spinner, String myString) {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void okButtonClicked(View view) {
        presenter.saveDifficultyLevel();
        goToBeginWorkoutActivity();
    }

    public void cancelButtonClicked(View view) {
        goToBeginWorkoutActivity();
    }

    public void goToBeginWorkoutActivity() {
        Intent intent = new Intent(this, BeginWorkoutActivity.class);
        startActivity(intent);
    }
}