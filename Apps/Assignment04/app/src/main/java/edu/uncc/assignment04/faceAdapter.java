package edu.uncc.assignment04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class faceAdapter extends ArrayAdapter<String> {


    public faceAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_mood, parent, false);
        }

        String[] fValue = {"0", "1", "2", "3", "4"};
        String[] moodList = {"Awful", "bad", "Ok", "Good", "Great"};

        TextView mood = convertView.findViewById(R.id.textViewMood);
        ImageView userFace = convertView.findViewById(R.id.imageViewMood);

        mood.setText(moodList[position]);

        if(fValue[position].equals("0")){
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.not_well));
        }
        else if (fValue[position].equals("1")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.sad));
        }
        else if (fValue[position].equals("2")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.ok));
        }
        else if (fValue[position].equals("3")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.good));
        }
        else if (fValue[position].equals("4")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.very_good));
        }
        return convertView;
    }
}
