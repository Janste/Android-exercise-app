package jansteczko.hiitbodyweightexercise.presenter;

import java.util.ArrayList;
import java.util.List;

import jansteczko.hiitbodyweightexercise.model.Exercise;
import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.WorkoutDetailsView;

public class WorkoutDetailsPresenter extends BasePresenter<WorkoutDatabase, WorkoutDetailsView> {

    private String workout;

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    @Override
    public void updateView() {
        List<Exercise> list = WorkoutDatabase.getInstance().getWorkout(workout);
        List<String> exerciseNames = new ArrayList<>();
        for (Exercise exercise: list) {
            exerciseNames.add(exercise.getName());
        }
        getView().createExerciseList(exerciseNames);
    }

    public void exerciseDetailsButtonPressed(String exerciseName) {
        getView().goToExerciseDetailsActivity(exerciseName);
    }

    public void exerciseClicked(String exerciseName) {
        getView().goToExerciseDetailsActivity(exerciseName);
    }

}
