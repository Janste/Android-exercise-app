package jansteczko.hiitbodyweightexercise.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutDatabase {

    public static final String PREFS_CURRENT_WORKOUT_NAME = "PrefsCurrentWorkoutName";
    public static final String PREFS_CURRENT_WORKOUT_KEY = "CurrentWorkoutKey";

    private static WorkoutDatabase instance;
    private static ExerciseDatabase exercises;
    private Map<String, List<Exercise>> workouts;

    private WorkoutDatabase() {
        workouts = new HashMap<>();
        exercises = ExerciseDatabase.getInstance();
        createWorkouts();
    }

    public static WorkoutDatabase getInstance() {
        if (instance == null) {
            instance = new WorkoutDatabase();
        }
        return instance;
    }

    public List<String> getWorkoutNames() {
        List<String> list = new ArrayList<>();
        list.addAll(workouts.keySet());
        return list;
    }

    public List<Exercise> getWorkout(String name) {
        return workouts.get(name);
    }

    public String getCurrentWorkout(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_CURRENT_WORKOUT_NAME, 0);
        return sharedPrefs.getString(PREFS_CURRENT_WORKOUT_KEY, "Whole Body");
    }

    public void setCurrentWorkout(Context context, String workoutName) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_CURRENT_WORKOUT_NAME, 0);
        SharedPreferences.Editor prefsEditor = sharedPrefs.edit();
        prefsEditor.putString(PREFS_CURRENT_WORKOUT_KEY, workoutName);
        prefsEditor.apply();
    }

    private void createWorkouts() {
        createWholeBodyWorkout();
        createArmsBackChestWorkout();
        createLegsButtWorkout();
        createAbsBodyWorkout();
        createArmsAbsWorkout();
        createChestAbsWorkout();
        createCardioLegsAbsWorkout();
        createCardioLegsWorkout();
    }

    private void createWholeBodyWorkout() {

        List<Exercise> wholeBodyWorkout = new ArrayList<>();

        wholeBodyWorkout.add(exercises.getBurpees());
        wholeBodyWorkout.add(exercises.getMountainClimbers());
        wholeBodyWorkout.add(exercises.getToeTouches());
        wholeBodyWorkout.add(exercises.getSquats());
        wholeBodyWorkout.add(exercises.getHighKnees());

        workouts.put("Whole Body", wholeBodyWorkout);
    }

    private void createArmsBackChestWorkout() {
        List<Exercise> upperBodyWorkout = new ArrayList<>();

        upperBodyWorkout.add(exercises.getPushUps());
        upperBodyWorkout.add(exercises.getRussianTwist());
        upperBodyWorkout.add(exercises.getPikePushUps());
        upperBodyWorkout.add(exercises.getSupermans());
        upperBodyWorkout.add(exercises.getTricepsDips());

        workouts.put("Chest + Arms + Back", upperBodyWorkout);
    }

    private void createArmsAbsWorkout() {
        List<Exercise> armsPlusAbsWorkout = new ArrayList<>();

        armsPlusAbsWorkout.add(exercises.getPushUpsInAndOuts());
        armsPlusAbsWorkout.add(exercises.getPlankTucks());
        armsPlusAbsWorkout.add(exercises.getLegRaises());
        armsPlusAbsWorkout.add(exercises.getBicycleCrunches());
        armsPlusAbsWorkout.add(exercises.getTricepsDips());

        workouts.put("Arms + Abs", armsPlusAbsWorkout);
    }

    private void createChestAbsWorkout() {
        List<Exercise> chestAbsWorkout = new ArrayList<>();

        chestAbsWorkout.add(exercises.getTrianglePushUps());
        chestAbsWorkout.add(exercises.getLeftSidePlank());
        chestAbsWorkout.add(exercises.getPikePushUps());
        chestAbsWorkout.add(exercises.getRightSidePlank());
        chestAbsWorkout.add(exercises.getPushUpsInAndOuts());

        workouts.put("Chest + Abs", chestAbsWorkout);
    }

    private void createLegsButtWorkout() {
        List<Exercise> legsButtWorkout = new ArrayList<>();

        legsButtWorkout.add(exercises.getSquatJumps());
        legsButtWorkout.add(exercises.getStepUps());
        legsButtWorkout.add(exercises.getButtLifts());
        legsButtWorkout.add(exercises.getJumpLunges());
        legsButtWorkout.add(exercises.getLegRaises());

        workouts.put("Legs + Butt", legsButtWorkout);
    }

    private void createCardioLegsAbsWorkout() {
        List<Exercise> workout = new ArrayList<>();

        workout.add(exercises.getSquatJumps());
        workout.add(exercises.getMountainClimbers());
        workout.add(exercises.getHighKnees());
        workout.add(exercises.getLegRaises());
        workout.add(exercises.getLunges());

        workouts.put("Legs + Cardio", workout);
    }

    private void createCardioLegsWorkout() {
        List<Exercise> workout = new ArrayList<>();

        workout.add(exercises.getJumpLunges());
        workout.add(exercises.getTuckJumps());
        workout.add(exercises.getPlank());
        workout.add(exercises.getPlankTucks());
        workout.add(exercises.getRussianTwist());

        workouts.put("Legs + Cardio + Abs", workout);
    }

    private void createAbsBodyWorkout() {
        List<Exercise> absWorkout = new ArrayList<>();

        absWorkout.add(exercises.getKneeToElbowPlank());
        absWorkout.add(exercises.getBicycleCrunches());
        absWorkout.add(exercises.getBurpees());
        absWorkout.add(exercises.getScissorsLegRaises());
        absWorkout.add(exercises.getVHolds());

        workouts.put("Abs", absWorkout);
    }
}