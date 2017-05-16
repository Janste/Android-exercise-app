package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.ChooseWorkoutPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class ChooseWorkoutActivity extends AppCompatActivity implements ChooseWorkoutView {

    private ChooseWorkoutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_workout_activity);
        setTitle("Choose Workout");

        if (savedInstanceState == null) {
            presenter = new ChooseWorkoutPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }
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

    public void createWorkoutList(List<String> workoutNamesList) {

        WorkoutListViewAdapter adapter = new WorkoutListViewAdapter(this, presenter);

        adapter.addSectionHeaderItem("Workouts list");
        for (String item : workoutNamesList) {
            adapter.addItem(item);
        }

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    public Context getContext() {
        return this.getApplicationContext();
    }

    public void goToPreviousActivity() {
        Intent intent = new Intent(this, BeginWorkoutActivity.class);
        startActivity(intent);
    }

    public void goToWorkoutDetailsActivity(String workoutName) {
        Intent intent = new Intent(this, WorkoutDetailsActivity.class);
        intent.putExtra("workout", workoutName);
        startActivity(intent);
    }
}
