package jansteczko.hiitbodyweightexercise.presenter;

import android.os.CountDownTimer;

import java.util.List;

import jansteczko.hiitbodyweightexercise.model.DifficultyLevel;
import jansteczko.hiitbodyweightexercise.model.DifficultyLevelDatabase;
import jansteczko.hiitbodyweightexercise.model.Exercise;
import jansteczko.hiitbodyweightexercise.model.WorkoutDatabase;
import jansteczko.hiitbodyweightexercise.view.DoWorkoutView;

public class DoWorkoutPresenter extends BasePresenter<WorkoutDatabase, DoWorkoutView> {

    private List<Exercise> workout;
    private DifficultyLevel level;
    private CountDownTimer timer;
    private int counter = 0;
    private int exerciseCounter = 0;
    private int timeRemaining = 11;

    private boolean firstRun = true;
    private boolean isPreparing = false;
    private boolean isPausedByUser = false;
    private boolean isPausedBySystem = false;
    private boolean exercising = false;
    private boolean exerciseDone = false;
    private boolean resting = false;
    private boolean restingDone = false;
    private boolean allDone = false;

    public void onResumeCalled() {
        isPausedBySystem = false;
    }

    public void onPauseCalled() {
        isPausedBySystem = true;
        updateView();
    }

    @Override
    public void updateView() {

        if (firstRun) { // First time we run the activity

            String name = WorkoutDatabase.getInstance().getCurrentWorkout(getView().getContext());
            workout = WorkoutDatabase.getInstance().getWorkout(name);

            name = DifficultyLevelDatabase.getInstance().getCurrentDifficultyLevel(getView().getContext());
            level = DifficultyLevelDatabase.getInstance().getDifficultyLevel(name);

            getView().showNextExerciseName(workout.get(counter).getName());
            getView().setImageView(android.R.color.transparent);
            getView().showPrepareForWorkout();

            runTimer(timeRemaining);

            firstRun = false;
            isPreparing = true;
            exercising = false;
            exerciseDone = false;
            resting = false;
            restingDone = false;
            allDone = false;

        }  else if ((isPausedByUser || isPausedBySystem) && exercising) { // Workout is paused when exercising

            if (timer != null) {
                timer.cancel();
                timer = null;
            }

            getView().showCurrentExerciseName(workout.get(counter-1).getName());
            getView().setImageView(workout.get(counter-1).getImage());
            getView().showTime(String.valueOf(timeRemaining));
            getView().showPauseScreen();

        } else if ((isPausedByUser || isPausedBySystem) && (resting || isPreparing)) { // Workout is paused when resting

            if (timer != null) {
                timer.cancel();
                timer = null;
            }
            getView().showNextExerciseName(workout.get(counter).getName());
            getView().setImageView(android.R.color.transparent);
            getView().showTime(String.valueOf(timeRemaining));
            getView().showPauseScreen();

        } else if (isPreparing) { // We are preparing for the workout

            getView().showNextExerciseName(workout.get(counter).getName());
            getView().setImageView(android.R.color.transparent);
            getView().showNormalScreen();
            runTimer(timeRemaining);

        } else if (exercising && !exerciseDone && !resting && !restingDone) { // We are currently exercising

            getView().showCurrentExerciseName(workout.get(counter-1).getName());
            getView().setImageView(workout.get(counter-1).getImage());
            getView().showNormalScreen();
            runTimer(timeRemaining);

        } else if (!exercising && exerciseDone && !resting && !restingDone) {  // We finished exercise but not yet resting

            getView().showNextExerciseName(workout.get(counter).getName());
            getView().setImageView(android.R.color.transparent);
            getView().showNormalScreen();
            getView().playLongAlarm();
            runTimer(level.getBreakTime() + 1);
            getView().showRest();

            exerciseDone = false;
            resting = true;

        } else if (resting && !restingDone && !exercising && !exerciseDone) { // We are currently resting

            getView().showNextExerciseName(workout.get(counter).getName());
            getView().setImageView(android.R.color.transparent);
            getView().showNormalScreen();
            runTimer(timeRemaining);
            getView().showRest();

        } else if (!resting && restingDone && !exercising && !exerciseDone) { // We are done resting but not yet exercising

            getView().hideRest();
            getView().showCurrentExerciseName(workout.get(counter).getName());
            getView().setImageView(workout.get(counter).getImage());
            getView().showNormalScreen();
            getView().playLongAlarm();
            runTimer(level.getWorkoutTime() + 1);
            exerciseCounter++;
            counter++;

            exercising = true;
            restingDone = false;

        } else if (allDone) { // We finished the workout

            getView().showNormalScreen();
            getView().showWorkoutFinished();

        }

        updateExerciseCounter();
    }

    private int getExerciseIndex() {
        if (counter < workout.size()) {
            return counter;
        } else if (exerciseCounter < (level.getRounds()*workout.size())) {
            counter = 0;
            return counter;
        } else {
            return -1;
        }
    }

    public void backButtonClicked() {
        getView().showExitDialog();
    }

    public void screenClicked() {
        pauseOrUnPause();
    }

    public void pauseOrUnPause() {
        if (timer != null) {
            isPausedByUser = true;
            updateView();
        } else {
            isPausedByUser = false;
            isPausedBySystem = false;
            updateView();
        }
    }

    public void countDownFinished() {

        if (isPreparing) { // We are preparing for the workout

            firstRun = false;
            isPreparing = false;
            exercising = false;
            exerciseDone = false;
            resting = false;
            restingDone = true;
            allDone = false;

            updateView();

        } else if (getExerciseIndex() == -1) {

            firstRun = false;
            isPreparing = false;
            exercising = false;
            exerciseDone = false;
            resting = false;
            restingDone = false;
            allDone = true;

            updateView();

        } else if (exercising && !exerciseDone && !resting && !restingDone) { // We are currently exercising

            firstRun = false;
            isPreparing = false;
            exercising = false;
            exerciseDone = true;
            resting = false;
            restingDone = false;
            allDone = false;

            updateView();

        } else if (!exercising && exerciseDone && !resting && !restingDone) {  // We finished exercise but not yet resting

            updateView();

        } else if (resting && !restingDone && !exercising && !exerciseDone) { // We are currently resting

            firstRun = false;
            isPreparing = false;
            exercising = false;
            exerciseDone = false;
            resting = false;
            restingDone = true;
            allDone = false;

            updateView();

        } else if (!resting && restingDone && !exercising && !exerciseDone) { // We are done resting but not yet exercising

            updateView();

        } else if (allDone) { // We finished the workout

            updateView();

        }

    }

    private void updateExerciseCounter() {
        getView().updateExerciseCounter(exerciseCounter, level.getRounds()*workout.size());
    }

    public void runTimer(int seconds) {

        seconds *= 1000;

        timer = new CountDownTimer(seconds, 1000) {

            public void onTick(long millisUntilFinished) {
                timeRemaining = (int) millisUntilFinished / 1000;
                getView().showTime(String.valueOf(millisUntilFinished / 1000));
                if (timeRemaining <= 5) {
                    getView().vibrate();
                    getView().playShortAlarm();
                }
            }

            public void onFinish() {
                countDownFinished();
            }
        }.start();
    }
}
