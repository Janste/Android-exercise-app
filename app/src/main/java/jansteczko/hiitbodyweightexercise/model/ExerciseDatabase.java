package jansteczko.hiitbodyweightexercise.model;

import java.util.HashMap;
import java.util.Map;

import jansteczko.hiitbodyweightexercise.R;

public class ExerciseDatabase {

    private String bicycleBrunchStr = "Bicycle crunch";
    private String burpeesStr = "Burpees";
    private String buttLiftsStr = "Butt lifts";
    private String highKneesStr = "High Knees";
    private String jumpLungesStr = "Jump lunges";
    private String kneeToElbowPlankStr = "Knee plank";
    private String legRaisesStr = "Leg raises";
    private String lungesStr = "Lunges";
    private String mountainClimbersStr = "Mountain Climbers";
    private String pikePushUpsStr = "Pike push ups";
    private String plankStr = "Plank";
    private String leftSidePlankStr = "Left side plank";
    private String rightSidePlankStr = "Right side plank";
    private String plankTucksStr = "Plank tucks";
    private String pushUpsInAndOutsStr = "Push ups - in and outs";
    private String pushUpsStr = "Push ups";
    private String russianTwistStr = "Russian twist";
    private String scissorsLegRaisesStr = "Scissors";
    private String squatJumpsStr = "Squat jumps";
    private String squatsStr = "Squats";
    private String stepUpsStr = "Step ups";
    private String supermansStr = "Supermans";
    private String toeTouchesStr = "Toe touches";
    private String trianglePushUpsStr = "Triangle push ups";
    private String tricepsDipsStr = "Triceps dips";
    private String tuckJumpsStr = "Tuck jumps";
    private String vHoldsStr = "V-holds";
    
    private String easyStr = "Easy";
    private String mediumStr = "Medium";
    private String hardStr = "Hard";

    private String wholeBodyStr = "Whole body";
    private String absStr = "Abs";
    private String legsStr = "Legs";
    private String armsStr = "Arms";
    private String backStr = "Back";
    private String chestStr = "Chest";
    

    private static ExerciseDatabase instance;
    private Map<String, Exercise> exercises;

    private ExerciseDatabase() {
        exercises = new HashMap<>();
        createExercises();
    }

    public static ExerciseDatabase getInstance() {
        if (instance == null) {
            instance = new ExerciseDatabase();
        }
        return instance;
    }

    public Exercise getExercise(String name) {
        return exercises.get(name);
    }

    public Exercise getBicycleCrunches() {
        return this.getExercise(bicycleBrunchStr);
    }

    public Exercise getBurpees() {
        return this.getExercise(burpeesStr);
    }

    public Exercise getButtLifts() {
        return this.getExercise(buttLiftsStr);
    }

    public Exercise getHighKnees() {
        return this.getExercise(highKneesStr);
    }

    public Exercise getJumpLunges() {
        return this.getExercise(jumpLungesStr);
    }

    public Exercise getKneeToElbowPlank() {
        return this.getExercise(kneeToElbowPlankStr);
    }

    public Exercise getLegRaises() {
        return this.getExercise(legRaisesStr);
    }

    public Exercise getLunges() {
        return this.getExercise(lungesStr);
    }

    public Exercise getMountainClimbers() {
        return this.getExercise(mountainClimbersStr);
    }

    public Exercise getPlank() {
        return this.getExercise(plankStr);
    }

    public Exercise getLeftSidePlank() {
        return this.getExercise(leftSidePlankStr);
    }

    public Exercise getRightSidePlank() {
        return this.getExercise(rightSidePlankStr);
    }

    public Exercise getPlankTucks() {
        return this.getExercise(plankTucksStr);
    }

    public Exercise getPikePushUps() {
        return this.getExercise(pikePushUpsStr);
    }

    public Exercise getPushUps() {
        return this.getExercise(pushUpsStr);
    }

    public Exercise getPushUpsInAndOuts() {
        return this.getExercise(pushUpsInAndOutsStr);
    }

    public Exercise getRussianTwist() {
        return this.getExercise(russianTwistStr);
    }

    public Exercise getScissorsLegRaises() {
        return this.getExercise(scissorsLegRaisesStr);
    }

    public Exercise getSquatJumps() {
        return this.getExercise(squatJumpsStr);
    }

    public Exercise getSquats() {
        return this.getExercise(squatsStr);
    }

    public Exercise getStepUps() {
        return this.getExercise(stepUpsStr);
    }

    public Exercise getSupermans() {
        return this.getExercise(supermansStr);
    }

    public Exercise getToeTouches() {
        return this.getExercise(toeTouchesStr);
    }

    public Exercise getTrianglePushUps() {
        return this.getExercise(trianglePushUpsStr);
    }

    public Exercise getTricepsDips() {
        return this.getExercise(tricepsDipsStr);
    }

    public Exercise getTuckJumps() {
        return this.getExercise(tuckJumpsStr);
    }

    public Exercise getVHolds() {
        return this.getExercise(vHoldsStr);
    }

    private void createExercises() {

        Exercise bicycleCrunch = new Exercise(bicycleBrunchStr);
        bicycleCrunch.setDifficultyLevel(easyStr);
        bicycleCrunch.setMusclesInvolved(absStr);
        bicycleCrunch.setImage(R.drawable.bicycle_crunch);
        exercises.put(bicycleCrunch.getName(), bicycleCrunch);

        Exercise burpees = new Exercise(burpeesStr);
        burpees.setDifficultyLevel(mediumStr);
        burpees.setMusclesInvolved(wholeBodyStr);
        burpees.setImage(R.drawable.burpee);
        exercises.put(burpees.getName(), burpees);

        Exercise buttLifts = new Exercise(buttLiftsStr);
        buttLifts.setDifficultyLevel(easyStr);
        buttLifts.setMusclesInvolved(legsStr);
        buttLifts.setImage(R.drawable.butt_lifts);
        exercises.put(buttLifts.getName(), buttLifts);

        Exercise highKnees = new Exercise(highKneesStr);
        highKnees.setDifficultyLevel(easyStr);
        highKnees.setMusclesInvolved(legsStr);
        highKnees.setImage(R.drawable.high_knees);
        exercises.put(highKnees.getName(), highKnees);

        Exercise jumpLunges = new Exercise(jumpLungesStr);
        jumpLunges.setDifficultyLevel(hardStr);
        jumpLunges.setMusclesInvolved(legsStr);
        jumpLunges.setImage(R.drawable.jump_lunges);
        exercises.put(jumpLunges.getName(), jumpLunges);

        Exercise kneeToElbowPlank = new Exercise(kneeToElbowPlankStr);
        kneeToElbowPlank.setDifficultyLevel(hardStr);
        kneeToElbowPlank.setMusclesInvolved(absStr);
        kneeToElbowPlank.setImage(R.drawable.knee_to_elbow_plank);
        exercises.put(kneeToElbowPlank.getName(), kneeToElbowPlank);

        Exercise legRaises = new Exercise(legRaisesStr);
        legRaises.setDifficultyLevel(easyStr);
        legRaises.setMusclesInvolved(absStr);
        legRaises.setImage(R.drawable.leg_raises);
        exercises.put(legRaises.getName(), legRaises);

        Exercise lunges = new Exercise(lungesStr);
        lunges.setDifficultyLevel(easyStr);
        lunges.setMusclesInvolved(legsStr);
        lunges.setImage(R.drawable.lunges);
        exercises.put(lunges.getName(), lunges);

        Exercise mountainClimbers = new Exercise(mountainClimbersStr);
        mountainClimbers.setDifficultyLevel(mediumStr);
        mountainClimbers.setMusclesInvolved(wholeBodyStr);
        mountainClimbers.setImage(R.drawable.mountain_climbers);
        exercises.put(mountainClimbers.getName(), mountainClimbers);

        Exercise plank = new Exercise(plankStr);
        plank.setDifficultyLevel(easyStr);
        plank.setMusclesInvolved(absStr);
        plank.setImage(R.drawable.plank);
        exercises.put(plank.getName(), plank);

        Exercise rightSidePlank = new Exercise(rightSidePlankStr);
        rightSidePlank.setDifficultyLevel(easyStr);
        rightSidePlank.setMusclesInvolved(absStr);
        rightSidePlank.setImage(R.drawable.plank_right_side);
        exercises.put(rightSidePlank.getName(), rightSidePlank);

        Exercise leftSidePlank = new Exercise(leftSidePlankStr);
        leftSidePlank.setDifficultyLevel(easyStr);
        leftSidePlank.setMusclesInvolved(absStr);
        leftSidePlank.setImage(R.drawable.plank_left_side);
        exercises.put(leftSidePlank.getName(), leftSidePlank);

        Exercise plankTucks = new Exercise(plankTucksStr);
        plankTucks.setDifficultyLevel(mediumStr);
        plankTucks.setMusclesInvolved(absStr);
        plankTucks.setImage(R.drawable.plank_tucks);
        exercises.put(plankTucks.getName(), plankTucks);

        Exercise pikePushUps = new Exercise(pikePushUpsStr);
        pikePushUps.setDifficultyLevel(mediumStr);
        pikePushUps.setMusclesInvolved(armsStr);
        pikePushUps.setImage(R.drawable.pike_push_ups);
        exercises.put(pikePushUps.getName(), pikePushUps);

        Exercise pushUps = new Exercise(pushUpsStr);
        pushUps.setDifficultyLevel(easyStr);
        pushUps.setMusclesInvolved(chestStr);
        pushUps.setImage(R.drawable.push_ups);
        exercises.put(pushUps.getName(), pushUps);

        Exercise pushUpsInAndOuts = new Exercise(pushUpsInAndOutsStr);
        pushUpsInAndOuts.setDifficultyLevel(mediumStr);
        pushUpsInAndOuts.setMusclesInvolved(chestStr);
        pushUpsInAndOuts.setImage(R.drawable.push_ups_in_and_outs);
        exercises.put(pushUpsInAndOuts.getName(), pushUpsInAndOuts);

        Exercise russianTwist = new Exercise(russianTwistStr);
        russianTwist.setDifficultyLevel(hardStr);
        russianTwist.setMusclesInvolved(absStr);
        russianTwist.setImage(R.drawable.russian_twist);
        exercises.put(russianTwist.getName(), russianTwist);

        Exercise scissorsLegRaises = new Exercise(scissorsLegRaisesStr);
        scissorsLegRaises.setDifficultyLevel(mediumStr);
        scissorsLegRaises.setMusclesInvolved(absStr);
        scissorsLegRaises.setImage(R.drawable.scissors_leg_raises);
        exercises.put(scissorsLegRaises.getName(), scissorsLegRaises);

        Exercise squatJumps = new Exercise(squatJumpsStr);
        squatJumps.setDifficultyLevel(hardStr);
        squatJumps.setMusclesInvolved(legsStr);
        squatJumps.setImage(R.drawable.squat_jumps);
        exercises.put(squatJumps.getName(), squatJumps);

        Exercise squats = new Exercise(squatsStr);
        squats.setDifficultyLevel(easyStr);
        squats.setMusclesInvolved(legsStr);
        squats.setImage(R.drawable.squats);
        exercises.put(squats.getName(), squats);

        Exercise stepUps = new Exercise(stepUpsStr);
        stepUps.setDifficultyLevel(easyStr);
        stepUps.setMusclesInvolved(legsStr);
        stepUps.setImage(R.drawable.step_ups);
        exercises.put(stepUps.getName(), stepUps);

        Exercise superMans = new Exercise(supermansStr);
        superMans.setDifficultyLevel(easyStr);
        superMans.setMusclesInvolved(backStr);
        superMans.setImage(R.drawable.supermans);
        exercises.put(superMans.getName(), superMans);

        Exercise toeTouches = new Exercise(toeTouchesStr);
        toeTouches.setDifficultyLevel(hardStr);
        toeTouches.setMusclesInvolved(absStr);
        toeTouches.setImage(R.drawable.toe_touches);
        exercises.put(toeTouches.getName(), toeTouches);

        Exercise trianglePushUps = new Exercise(trianglePushUpsStr);
        trianglePushUps.setDifficultyLevel(mediumStr);
        trianglePushUps.setMusclesInvolved(armsStr);
        trianglePushUps.setImage(R.drawable.triangle_push_ups);
        exercises.put(trianglePushUps.getName(), trianglePushUps);

        Exercise tricepsDips = new Exercise(tricepsDipsStr);
        tricepsDips.setDifficultyLevel(easyStr);
        tricepsDips.setMusclesInvolved(armsStr);
        tricepsDips.setImage(R.drawable.triceps_dips);
        exercises.put(tricepsDips.getName(), tricepsDips);

        Exercise tuckJumps = new Exercise(tuckJumpsStr);
        tuckJumps.setDifficultyLevel(easyStr);
        tuckJumps.setMusclesInvolved(legsStr);
        tuckJumps.setImage(R.drawable.tuck_jumps);
        exercises.put(tuckJumps.getName(), tuckJumps);

        Exercise vHolds = new Exercise(vHoldsStr);
        vHolds.setDifficultyLevel(hardStr);
        vHolds.setMusclesInvolved(absStr);
        vHolds.setImage(R.drawable.v_holds);
        exercises.put(vHolds.getName(), vHolds);

    }
}
