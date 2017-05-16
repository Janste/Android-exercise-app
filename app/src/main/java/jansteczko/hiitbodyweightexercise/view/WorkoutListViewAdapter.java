package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.ChooseWorkoutPresenter;

public class WorkoutListViewAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private ArrayList<String> items = new ArrayList<>();
    private TreeSet<Integer> headers = new TreeSet<>();
    private LayoutInflater inflater;
    private ChooseWorkoutPresenter presenter;

    public WorkoutListViewAdapter(Context context, ChooseWorkoutPresenter presenter) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.presenter = presenter;
    }

    public void addItem(final String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final String item) {
        items.add(item);
        headers.add(items.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return headers.contains(position) ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        int rowType = getItemViewType(position);

        if (view == null) {
            switch (rowType) {
                case TYPE_ITEM:
                    view = inflater.inflate(R.layout.workouts_list_view_item, null);

                    TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
                    listItemText.setText(items.get(position));

                    final View finalView = view;
                    view.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            finalView.setBackgroundColor(0xFFe2e2e2);
                            presenter.onSelectButtonClick(items.get(position));
                            notifyDataSetChanged();
                        }
                    });

                    ImageButton moreInfoButton = (ImageButton)view.findViewById(R.id.more_info_button);
                    moreInfoButton.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            presenter.onMoreInfoButtonClick(items.get(position));
                            notifyDataSetChanged();
                        }
                    });

                    break;
                case TYPE_HEADER:
                    view = inflater.inflate(R.layout.workouts_list_view_header, null);

                    TextView headerItemText = (TextView) view.findViewById(R.id.header_of_list_view);
                    headerItemText.setText(items.get(position));

                    break;
            }
        }
        return view;
    }
}
