package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;

import java.util.List;

import jansteczko.hiitbodyweightexercise.model.Exercise;

public interface PrepareForWorkoutView {
    Context getContext();
    void goToDoWorkoutActivity();
    void showExercises(List<Exercise> list);
}
