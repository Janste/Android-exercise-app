package jansteczko.hiitbodyweightexercise.model;

public class Exercise {

    private String name;
    private String generalDescription;
    private String firstPartDescription;
    private String secondPartDescription;
    private String thirdPartDescription;
    private String fourthPartDescription;
    private String endDescription;
    private int image;
    private String difficultyLevel;
    private String musclesInvolved;

    public Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String description) {
        this.generalDescription = description;
    }

    public String getFirstPartDescription() {
        return firstPartDescription;
    }

    public void setFirstPartDescription(String firstPartDescription) {
        this.firstPartDescription = firstPartDescription;
    }

    public String getSecondPartDescription() {
        return secondPartDescription;
    }

    public void setSecondPartDescription(String secondPartDescription) {
        this.secondPartDescription = secondPartDescription;
    }

    public String getThirdPartDescription() {
        return thirdPartDescription;
    }

    public void setThirdPartDescription(String thirdPartDescription) {
        this.thirdPartDescription = thirdPartDescription;
    }

    public String getFourthPartDescription() {
        return fourthPartDescription;
    }

    public void setFourthPartDescription(String fourthPartDescription) {
        this.fourthPartDescription = fourthPartDescription;
    }

    public String getEndDescription() {
        return endDescription;
    }

    public void setEndDescription(String endDescription) {
        this.endDescription = endDescription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String level) {
        this.difficultyLevel = level;
    }

    public String getMusclesInvolved() {
        return musclesInvolved;
    }

    public void setMusclesInvolved(String musclesInvolved) {
        this.musclesInvolved = musclesInvolved;
    }

}