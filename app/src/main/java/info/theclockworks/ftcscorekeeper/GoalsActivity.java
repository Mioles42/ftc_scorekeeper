package info.theclockworks.ftcscorekeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

public class GoalsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        setTitle("Goals");
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onRestart() { super.onRestart(); }
    protected void onResume() {super.onResume(); }
    protected void onPause() {super.onPause(); }
    protected void onStop() {super.onStop(); }
    protected void onDestroy() {super.onDestroy(); }

    public void toNewGoal(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));

        Intent intent = new Intent(this, NewGoalActivity.class);
        startActivity(intent);
    }

    public void toNewGoalSet(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));
    }

    public void toViewGoals(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_image_click));

        Intent intent = new Intent(this, ViewGoalsActivity.class);
        startActivity(intent);
    }
}
