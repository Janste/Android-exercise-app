package jansteczko.hiitbodyweightexercise.presenter;

import jansteczko.hiitbodyweightexercise.model.Exercise;
import jansteczko.hiitbodyweightexercise.model.ExerciseDatabase;
import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.ExerciseDetailsView;

public class ExerciseDetailsPresenter extends BasePresenter<WorkoutDatabase, ExerciseDetailsView> {

    private Exercise exercise;

    public void setExercise(String exerciseName) {
        exercise = ExerciseDatabase.getInstance().getExercise(exerciseName);
    }

    @Override
    public void updateView() {
        getView().setExerciseTitle(exercise.getName());
        getView().setDifficultyLevelTextView(exercise.getDifficultyLevel());
        getView().setMusclesInvolvedTextView(exercise.getMusclesInvolved());
        getView().setImage(exercise.getImage());
    }

    public void backButtonPressed() {
        getView().goToWorkoutDetailsActivity();
    }

}
