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

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_user, parent, false);
        }

        User user = getItem(position);
        TextView userName = convertView.findViewById(R.id.textViewUserName);
        TextView ageGroup = convertView.findViewById(R.id.textViewUserAgeGroup);
        ImageView userFace = convertView.findViewById(R.id.imageViewUserMood);

        userName.setText(user.name);
        ageGroup.setText(user.age);

        if(user.fValue.equals("0")){
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.not_well));
        }
        else if (user.fValue.equals("1")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.sad));
        }
        else if (user.fValue.equals("2")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.ok));
        }
        else if (user.fValue.equals("3")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.good));
        }
        else if (user.fValue.equals("4")) {
            userFace.setImageDrawable(convertView.getResources().getDrawable(R.drawable.very_good));
        }


        return convertView;
    }
}
