package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;

import java.util.List;

public interface ChooseWorkoutView {
    Context getContext();
    void goToPreviousActivity();
    void goToWorkoutDetailsActivity(String workoutName);
    void createWorkoutList(List<String> list);
}
