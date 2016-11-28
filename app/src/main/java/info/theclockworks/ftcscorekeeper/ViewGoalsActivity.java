package info.theclockworks.ftcscorekeeper;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewGoalsActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);
        setTitle("About FTC Scorekeeper");
    }

    protected void onStart() {
        super.onStart();
        List<FTCGoal> goals = MainActivity.loadGoals(this.getApplicationContext());

        list = (ListView) findViewById(R.id.goals_list_view);

        //Convert our List<FTCGoal> into a FTCGoal[]
        String[] listItems = new String[goals.size()];
        for(int i = 0; i < goals.size(); i++){
            FTCGoal g = goals.get(i);
            listItems[i] = g.getName();
        }

        ViewGoalsAdapter adapter = new ViewGoalsAdapter(getApplicationContext(), goals);
        list.setAdapter(adapter);
    }

    protected void onRestart() { super.onRestart(); }
    protected void onResume() {super.onResume(); }
    protected void onPause() {super.onPause(); }
    protected void onStop() {super.onStop(); }
    protected void onDestroy() {super.onDestroy(); }
}
