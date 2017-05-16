package jansteczko.hiitbodyweightexercise.presenter;

import java.util.Collections;
import java.util.List;

import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.ChooseWorkoutView;

public class ChooseWorkoutPresenter extends BasePresenter<WorkoutDatabase, ChooseWorkoutView> {

    @Override
    public void updateView() {
        getView().createWorkoutList(getWorkoutList());
    }

    public void onSelectButtonClick(String workoutName) {
        WorkoutDatabase.getInstance().setCurrentWorkout(getView().getContext(), workoutName);
        getView().goToPreviousActivity();
    }

    public void onMoreInfoButtonClick(String workoutName) {
        getView().goToWorkoutDetailsActivity(workoutName);
    }

    private List<String> getWorkoutList() {
        List<String> list = WorkoutDatabase.getInstance().getWorkoutNames();
        Collections.sort(list);
        return list;
    }

}
