package info.theclockworks.ftcscorekeeper;

import android.app.ActionBar;
import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NewGoalActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    FTCGoal goal;
    SeekBar pointValueSeekBar;
    SeekBar maximumTimesScorableSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goal);
        setTitle("New Goal");

        pointValueSeekBar = (SeekBar) findViewById(R.id.point_value_seek_bar);
        pointValueSeekBar.setOnSeekBarChangeListener(this);

        maximumTimesScorableSeekBar = (SeekBar) findViewById(R.id.maximum_times_scorable_seek_bar);
        maximumTimesScorableSeekBar.setOnSeekBarChangeListener(this);
    }

    protected void onStart() {
        super.onStart();
        goal = new FTCGoal();
    }

    protected void onStop() {
        super.onStop();

        String name = ((EditText) findViewById(R.id.goal_name_entry)).getText().toString();
        String toastMessage = "";

        if(! (name.equals(""))) {

            String filename = name + System.currentTimeMillis();

            goal.setName(name);
            goal.setFilename(filename);
            goal.setTimesCanBeAccomplished((maximumTimesScorableSeekBar.getProgress() == 0) ? 1 : maximumTimesScorableSeekBar.getProgress());
            goal.setValue(pointValueSeekBar.getProgress());

            try {
                File outLocation = new File(getApplicationContext().getFilesDir() + "/goal/", filename);
                Log.d("newGoal done", "[SCOREKEEPER] Attempting to create file at " + outLocation.getAbsolutePath());
                outLocation.createNewFile();
                FileOutputStream fileOut = new FileOutputStream(outLocation);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(goal);
                fileOut.close();
                objectOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            toastMessage = "Saved goal \"" + name + "\"";
        } else {
            toastMessage = "Goal not saved.";
        }

        Context context = getApplicationContext();
        int duration =  Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }
    protected void onRestart() { super.onRestart(); }
    protected void onResume() {super.onResume(); }
    protected void onPause() {super.onPause(); }
    protected void onDestroy() {super.onDestroy(); }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar == pointValueSeekBar) {
            TextView seekBarLabel = (TextView) findViewById(R.id.point_value_text);
            seekBarLabel.setText("Point value: " + seekBar.getProgress());
        }
        if(seekBar == maximumTimesScorableSeekBar) {
            TextView seekBarLabel = (TextView) findViewById(R.id.maximum_times_scorable_text);
            seekBarLabel.setText("Maximum times obtainable: " + ((seekBar.getProgress() == 0)? 1 : seekBar.getProgress()));
        }
    }

    public void done(View view) {

        finish();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
