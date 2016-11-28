package info.theclockworks.ftcscorekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by commandm on 7/17/16.
 */
public class ViewGoalsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<FTCGoal> dataSource;

    public ViewGoalsAdapter(Context context, List<FTCGoal> items) {
        this.context = context;
        this.dataSource = items;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = inflater.inflate(R.layout.goal_listing, parent, false);

        TextView text = (TextView) rowView.findViewById(R.id.goal_listing_text);
        text.setText(dataSource.get(position).getName());

        return rowView;
    }
}
