package jansteczko.hiitbodyweightexercise.view;

public interface ExerciseDetailsView {
    void goToWorkoutDetailsActivity();
    void setExerciseTitle(String text);
    void setGeneralDescription(String text);
    void setDifficultyLevelTextView(String text);
    void setMusclesInvolvedTextView(String text);
    void setImage(int resource);
}
