package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;

import java.util.List;

public interface ChooseDifficultyView {
    Context getContext();
    void initializeSpinners(List<String> levels, String currentLevel);
    void setWorkoutTimeTextView(String time);
    void setBreakTimeTextView(String time);
    void setExercisesPerRoundTextView(String text);
    void setRoundsTimeTextView(String text);
    void setTotalTimeTextView(String time);
}
