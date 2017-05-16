package jansteczko.hiitbodyweightexercise.view;

import java.util.List;

public interface WorkoutDetailsView {
    void createExerciseList(List<String> exerciseList);
    void goToExerciseDetailsActivity(String exerciseName);
}
