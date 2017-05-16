package jansteczko.hiitbodyweightexercise.presenter;

import java.util.List;

import jansteczko.hiitbodyweightexercise.model.Exercise;
import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.PrepareForWorkoutView;

public class PrepareForWorkoutPresenter extends BasePresenter<WorkoutDatabase, PrepareForWorkoutView> {

    @Override
    public void updateView() {
        String name = WorkoutDatabase.getInstance().getCurrentWorkout(getView().getContext());
        List<Exercise> list = WorkoutDatabase.getInstance().getWorkout(name);
        getView().showExercises(list);
    }

    public void startWorkoutButtonTapped() {
        getView().goToDoWorkoutActivity();
    }
}
