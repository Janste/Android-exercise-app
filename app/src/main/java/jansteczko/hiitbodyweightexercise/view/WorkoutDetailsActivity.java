package jansteczko.hiitbodyweightexercise.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;
import jansteczko.hiitbodyweightexercise.presenter.WorkoutDetailsPresenter;

public class WorkoutDetailsActivity extends AppCompatActivity implements WorkoutDetailsView {

    private WorkoutDetailsPresenter presenter;
    private String workout;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_details_activity);
        setTitle("Workout Details");

        if (savedInstanceState == null) {
            presenter = new WorkoutDetailsPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        title = (TextView) findViewById(R.id.workout_details_text_view);
        workout = getIntent().getExtras().getString("workout");

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.bindView(this);
        String titleText = workout + " Workout";
        title.setText(titleText);
        presenter.setWorkout(workout);
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

    public void createExerciseList(List<String> exerciseList) {
        ExerciseListViewAdapter adapter = new ExerciseListViewAdapter(exerciseList, this, presenter);
        ListView listView = (ListView) findViewById(R.id.workout_details_list_view);
        listView.setAdapter(adapter);
    }

    public void goToExerciseDetailsActivity(String exerciseName) {
        Intent intent = new Intent(this, ExerciseDetailsActivity.class);
        intent.putExtra("exercise", exerciseName);
        intent.putExtra("workout", workout);
        startActivity(intent);
    }
}
