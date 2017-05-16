package jansteczko.hiitbodyweightexercise.presenter;

import jansteczko.hiitbodyweightexercise.model.DifficultyLevelDatabase;
import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.BeginWorkoutView;

public class BeginWorkoutPresenter extends BasePresenter<WorkoutDatabase, BeginWorkoutView> {

    @Override
    public void updateView() {
        String text = WorkoutDatabase.getInstance().getCurrentWorkout(getView().getContext());
        getView().setCurrentWorkoutTextView(text);

        text = DifficultyLevelDatabase.getInstance().getCurrentDifficultyLevel(getView().getContext());
        getView().setDifficultyLevelTextView(text);
    }

    public void backButtonPressed() {
        getView().goToMainActivity();
    }

    public void beginTrainingButtonClicked() {
        getView().goToPrepareForWorkoutActivity();
    }

    public void chooseWorkoutActivityButtonClicked() {
        getView().goToChooseWorkoutActivity();
    }

    public void chooseDifficultyActivityButtonClicked() {
        getView().goToChooseDifficultyActivity();
    }

}
