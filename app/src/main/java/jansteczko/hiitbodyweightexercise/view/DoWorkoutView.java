package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;

public interface DoWorkoutView {
    Context getContext();
    void showCurrentExerciseName(String name);
    void showNextExerciseName(String name);
    void showWorkoutFinished();
    void showRest();
    void hideRest();
    void showPrepareForWorkout();
    void updateExerciseCounter(int current, int total);
    void setImageView(int resource);
    void showPauseScreen();
    void showNormalScreen();
    void showExitDialog();
    void showTime(String time);
    void playShortAlarm();
    void playLongAlarm();
    void vibrate();
}
