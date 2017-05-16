package jansteczko.hiitbodyweightexercise.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.ExerciseDetailsPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class ExerciseDetailsActivity extends AppCompatActivity implements ExerciseDetailsView {

    private ExerciseDetailsPresenter presenter;
    private String workout;
    private String exercise;

    private ImageView imageView;
    private TextView title;
    private TextView difficultyLevelTextView;
    private TextView musclesInvolvedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_details_activity);
        setTitle("Exercise Details");

        if (savedInstanceState == null) {
            presenter = new ExerciseDetailsPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }


        workout = getIntent().getExtras().getString("workout");
        exercise = getIntent().getExtras().getString("exercise");

        imageView = (ImageView) findViewById(R.id.exercise_image_view);
        title = (TextView) findViewById(R.id.exercise_title_text_view);
        difficultyLevelTextView = (TextView) findViewById(R.id.exercise_details_level_text_view);
        musclesInvolvedTextView = (TextView) findViewById(R.id.exercise_details_muscles_involved_text_view);

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.bindView(this);
        presenter.setExercise(exercise);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                presenter.backButtonPressed();
                break;
        }
        return true;
    }

    public void goToWorkoutDetailsActivity() {
        Intent intent = new Intent(this, WorkoutDetailsActivity.class);
        intent.putExtra("workout", workout);
        startActivity(intent);
    }

    public void setExerciseTitle(String text) {
        title.setText(text);
    }

    public void setGeneralDescription(String text) {
    }

    public void setDifficultyLevelTextView(String text) {
        text = "Difficulty: " + text;
        difficultyLevelTextView.setText(text);
    }

    public void setMusclesInvolvedTextView(String text) {
        text = "Muscles: " + text;
        musclesInvolvedTextView.setText(text);
    }

    public void setImage(int resource) {
        imageView.setImageResource(resource);
    }


}
