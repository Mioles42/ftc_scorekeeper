package info.theclockworks.ftcscorekeeper;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() { super.onStart(); }
    protected void onRestart() { super.onRestart(); }
    protected void onResume() {super.onResume(); }
    protected void onPause() {super.onPause(); }
    protected void onStop() {super.onStop(); }
    protected void onDestroy() {super.onDestroy(); }

    public void toMatches(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));
        Log.d("test", "[SCOREKEEPER] Matches button detected");
    }

    public void toGoals(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));
        Log.d("test", "[SCOREKEEPER] Goals button detected");

        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }

    public void toRecords(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));
        Log.d("test", "[SCOREKEEPER] Records button detected");
    }

    public void toAbout(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));
        Log.d("test", "[SCOREKEEPER] About button detected");

        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public static List<FTCGoal> loadGoals(Context context) {
        List<FTCGoal> result = new ArrayList<FTCGoal>();
        // We need to pull all of the Goal files from the databank, which hopefully won't
        // take too long. We'll find a directory
        File filesDir = new File(context.getFilesDir(), "/goal");

        //If that directory doesn't exist, let's make it
        if(! filesDir.exists()) filesDir.mkdir();

        // Get a list of all files in the directory.
        File[] goalFiles = filesDir.listFiles();
        Log.d("goalFiles", "[SCOREKEEPER] Loading Goal files to " + goalFiles.toString());

        //Pull the data from the Files
        FileInputStream fileStream;
        ObjectInputStream objectStream;
        for(File file: goalFiles) {
            try {
                fileStream = new FileInputStream(file);
                objectStream = new ObjectInputStream(fileStream);
                result.add((FTCGoal) objectStream.readObject());
                fileStream.close();
                objectStream.close();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        Log.d("goalFiles", "Found the following goals: ");
        for(FTCGoal f: result) Log.d("goalFiles", f.getName());

        return result;
    }
}
