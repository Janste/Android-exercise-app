package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;

public interface BeginWorkoutView {
    Context getContext();
    void setCurrentWorkoutTextView(String text);
    void setDifficultyLevelTextView(String text);
    void goToMainActivity();
    void goToChooseWorkoutActivity();
    void goToChooseDifficultyActivity();
    void goToPrepareForWorkoutActivity();
}
