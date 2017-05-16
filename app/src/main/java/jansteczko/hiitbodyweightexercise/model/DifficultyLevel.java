package jansteczko.hiitbodyweightexercise.model;

public class DifficultyLevel {

    private String name;
    private int workoutTime;
    private int breakTime;
    private int rounds;
    private int exercisesPerRound;

    public DifficultyLevel(String name, int workoutTime, int breakTime, int exercisesPerRound, int rounds) {
        this.name = name;
        this.workoutTime = workoutTime;
        this.breakTime = breakTime;
        this.rounds = rounds;
        this.exercisesPerRound = exercisesPerRound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(int workoutTime) {
        this.workoutTime = workoutTime;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    public int getExercisesPerRound() {
        return exercisesPerRound;
    }

    public void setExercisesPerRound(int exercisesPerRound) {
        this.exercisesPerRound = exercisesPerRound;
    }

}
