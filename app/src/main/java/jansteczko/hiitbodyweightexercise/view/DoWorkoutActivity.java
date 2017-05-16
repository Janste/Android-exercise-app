package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.DoWorkoutPresenter;
import jansteczko.hiitbodyweightexercise.presenter.PresenterManager;

public class DoWorkoutActivity extends AppCompatActivity implements DoWorkoutView {

    private DoWorkoutPresenter presenter;
    private MediaPlayer mediaPlayer;
    private MediaPlayer shortSoundMediaPlayer;
    private RelativeLayout overlay;
    private TextView timeTextView;
    private TextView exerciseNameTextView;
    private TextView exerciseCounterTextView;
    private TextView restTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.do_workout_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setTitle("Workout");

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if (savedInstanceState == null) {
            presenter = new DoWorkoutPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        overlay = (RelativeLayout) findViewById(R.id.workout_paused_overlay);
        mediaPlayer = MediaPlayer.create(this, R.raw.long_blip);
        shortSoundMediaPlayer = MediaPlayer.create(this, R.raw.short_blip);

        timeTextView = (TextView) findViewById(R.id.time_text_view);
        exerciseNameTextView = (TextView) findViewById(R.id.do_workout_exercise_name_text_view);
        exerciseCounterTextView = (TextView) findViewById(R.id.exercise_counter_text_view);
        restTextView = (TextView) findViewById(R.id.do_workout_rest_text_view);
        imageView = (ImageView) findViewById(R.id.do_workout_exercise_image_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.bindView(this);
        presenter.onResumeCalled();
        presenter.updateView();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPauseCalled();
        presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(300);
    }

    public void playShortAlarm() {
        shortSoundMediaPlayer.start();
    }

    public void playLongAlarm() {
        mediaPlayer.start();
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public void showCurrentExerciseName(String name) {
        exerciseNameTextView.setText(name);
    }

    public void showNextExerciseName(String name) {
        String str = getResources().getString(R.string.next_exercise);
        str = str + ": \n" + name;
        exerciseNameTextView.setText(str);
    }

    public void showWorkoutFinished() {
        String str = getResources().getString(R.string.workout_finished);
        exerciseNameTextView.setText(str);
        timeTextView.setText("0");

        new AlertDialog.Builder(this).setTitle(
                R.string.workout_finished).setCancelable(false)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                goToBeginWorkoutActivity();
                            }
                        }).show();
    }

    public void showRest() {
        String str = getResources().getString(R.string.rest);
        restTextView.setText(str);
    }

    public void hideRest() {
        restTextView.setText("");
    }

    public void showPrepareForWorkout() {
        String str = getResources().getString(R.string.prepare);
        restTextView.setText(str);
    }

    public void showTime(String time) {
        timeTextView.setText(time);
    }

    public void updateExerciseCounter(int current, int total) {
        String str = getResources().getString(R.string.exercise_capitalized);
        str = str + " " + current + "/" + total;
        exerciseCounterTextView.setText(str);
    }

    public void setImageView(int resource) {
        if (imageView != null) {
            imageView.setImageResource(resource);
        }
    }

    public void screenClick(View view) {
        presenter.screenClicked();
    }

    public void showPauseScreen() {
        overlay.setVisibility(View.VISIBLE);
    }

    public void showNormalScreen() {
        overlay.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        presenter.backButtonClicked();
    }

    public void showExitDialog() {
        new AlertDialog.Builder(this).setTitle(
                R.string.exit_workout).setCancelable(false)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                goToBeginWorkoutActivity();
                            }
                        }).setNeutralButton(R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Do nothing
                    }
                }).show();
    }

    public void goToBeginWorkoutActivity() {
        Intent intent = new Intent(this, BeginWorkoutActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case android.R.id.home:
                presenter.backButtonClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
