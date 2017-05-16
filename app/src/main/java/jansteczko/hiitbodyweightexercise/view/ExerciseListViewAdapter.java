package jansteczko.hiitbodyweightexercise.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jansteczko.hiitbodyweightexercise.R;
import jansteczko.hiitbodyweightexercise.presenter.WorkoutDetailsPresenter;

public class ExerciseListViewAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;
    private WorkoutDetailsPresenter presenter;

    public ExerciseListViewAdapter(List<String> list, Context context, WorkoutDetailsPresenter presenter) {
        this.list = new ArrayList<>(list);
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        //return list.get(pos).getId();
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.workout_details_list_view_item, null);
        }

        TextView listItemText = (TextView)view.findViewById(R.id.list_item_text_view);
        listItemText.setText(list.get(position));

        ImageButton moreInfoButton = (ImageButton)view.findViewById(R.id.details_button);

        moreInfoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                presenter.exerciseDetailsButtonPressed(list.get(position));
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
