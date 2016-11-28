package info.theclockworks.ftcscorekeeper;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import java.util.List;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About FTC Scorekeeper");
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onRestart() { super.onRestart(); }
    protected void onResume() {super.onResume(); }
    protected void onPause() {super.onPause(); }
    protected void onStop() {super.onStop(); }
    protected void onDestroy() {super.onDestroy(); }
}
