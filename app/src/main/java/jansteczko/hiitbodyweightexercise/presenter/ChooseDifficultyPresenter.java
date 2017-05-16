package jansteczko.hiitbodyweightexercise.presenter;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import jansteczko.hiitbodyweightexercise.model.DifficultyLevel;
import jansteczko.hiitbodyweightexercise.model.DifficultyLevelDatabase;
import jansteczko.hiitbodyweightexercise.view.ChooseDifficultyView;

public class ChooseDifficultyPresenter extends BasePresenter<DifficultyLevelDatabase, ChooseDifficultyView> {

    private DifficultyLevelDatabase difficultyDb;
    private String selectedLevel;

    public ChooseDifficultyPresenter() {
        difficultyDb = DifficultyLevelDatabase.getInstance();
    }

    @Override
    public void updateView() {
        getView().initializeSpinners(difficultyDb.getDifficultyLevelNames(), difficultyDb.getCurrentDifficultyLevel(getView().getContext()));
    }

    public void difficultyLevelSelected(String selectedLevelName) {
        DifficultyLevel level = difficultyDb.getDifficultyLevel(selectedLevelName);

        selectedLevel = selectedLevelName;

        getView().setWorkoutTimeTextView(Integer.toString(level.getWorkoutTime()));
        getView().setBreakTimeTextView(Integer.toString(level.getBreakTime()));
        getView().setExercisesPerRoundTextView(Integer.toString(level.getExercisesPerRound()));
        getView().setRoundsTimeTextView(Integer.toString(level.getRounds()));

        double total = level.getWorkoutTime() + level.getBreakTime();
        total *= level.getExercisesPerRound();
        total *= level.getRounds();
        total /= 60;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        getView().setTotalTimeTextView(df.format(total));
    }

    public void saveDifficultyLevel() {
        if (selectedLevel != null) {
            DifficultyLevelDatabase.getInstance().setCurrentDifficultyLevel(getView().getContext(), selectedLevel);
        }
    }
}
