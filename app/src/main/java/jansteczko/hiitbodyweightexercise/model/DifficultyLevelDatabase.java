package jansteczko.hiitbodyweightexercise.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DifficultyLevelDatabase {

    public static final String PREFS_CURRENT_DIFFICULTY_LEVEL_NAME = "PrefsCurrentDifficultyLevelName";
    public static final String PREFS_CURRENT_DIFFICULTY_LEVEL_KEY = "PrefsCurrentDifficultyLevelKey";

    private static DifficultyLevelDatabase instance;
    private Map<String, DifficultyLevel> levels;

    private DifficultyLevelDatabase() {
        levels = new LinkedHashMap<>();
        createDifficultyLevels();
    }

    public static DifficultyLevelDatabase getInstance() {
        if (instance == null) {
            instance = new DifficultyLevelDatabase();
        }
        return instance;
    }

    public List<String> getDifficultyLevelNames() {
        List<String> list = new ArrayList<>();
        list.addAll(levels.keySet());
        return list;
    }

    public DifficultyLevel getDifficultyLevel(String name) {
        return levels.get(name);
    }

    public String getCurrentDifficultyLevel(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_CURRENT_DIFFICULTY_LEVEL_NAME, 0);
        return sharedPrefs.getString(PREFS_CURRENT_DIFFICULTY_LEVEL_KEY, "Medium");
    }

    public void setCurrentDifficultyLevel(Context context, String levelName) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREFS_CURRENT_DIFFICULTY_LEVEL_NAME, 0);
        SharedPreferences.Editor prefsEditor = sharedPrefs.edit();
        prefsEditor.putString(PREFS_CURRENT_DIFFICULTY_LEVEL_KEY, levelName);
        prefsEditor.apply();
    }

    private void createDifficultyLevels() {
        createEasyDifficultyLevel();
        createMediumDifficultyLevel();
        createHardDifficultyLevel();
        createSolidDifficultyLevel();
        createProDifficultyLevel();
    }

    private void createEasyDifficultyLevel() {
        DifficultyLevel level = new DifficultyLevel("Easy", 20, 20, 5, 3);
        levels.put("Easy", level);
    }

    private void createMediumDifficultyLevel() {
        DifficultyLevel level = new DifficultyLevel("Medium", 30, 30, 5, 3);
        levels.put("Medium", level);
    }

    private void createHardDifficultyLevel() {
        DifficultyLevel level = new DifficultyLevel("Solid", 45, 30, 5, 3);
        levels.put("Solid", level);
    }

    private void createSolidDifficultyLevel() {
        DifficultyLevel level = new DifficultyLevel("Pro", 60, 30, 5, 3);
        levels.put("Pro", level);
    }

    private void createProDifficultyLevel() {
        DifficultyLevel level = new DifficultyLevel("Extreme", 90, 45, 5, 2);
        levels.put("Extreme", level);
    }
}
