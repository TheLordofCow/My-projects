package edu.uncc.assessment02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.uncc.assessment02.models.CreditCategory;

public class CreditAdapter extends ArrayAdapter<CreditCategory> {

    public CreditAdapter(@NonNull Context context, int resource, @NonNull CreditCategory[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.credit_criteria_list_item, parent, false);
        }
        String[] fValue = {"0", "1", "2", "3", "4"};
        String[] moodList = {"Awful", "bad", "Ok", "Good", "Great"};

        return convertView;
    }
}

