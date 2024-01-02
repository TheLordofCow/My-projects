package edu.uncc.assignment05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    ArrayList<User> users;
    Context context;
    userAdp listen;

    public UserAdapter(ArrayList<User> data, Context context, userAdp listen){
        this.users = data;
        this.context = context;
        this.listen = listen;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        UserHolder viewHolder = new UserHolder(view, listen);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = users.get(position);
        holder.user = user;
        holder.userName.setText(user.name);
        holder.ageGroup.setText(user.age);
        holder.userFace.setImageDrawable(context.getResources().getDrawable(user.mood.imageResourceId));
        holder.position = holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public static class UserHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView ageGroup;
        ImageView userFace;
        ImageView trash;
        int position;
        userAdp listen;
        User user;
        public UserHolder(@NonNull View itemView, userAdp listen) {
            super(itemView);
            userName = itemView.findViewById(R.id.textViewUserName);
            ageGroup = itemView.findViewById(R.id.textViewUserAgeGroup);
            userFace = itemView.findViewById(R.id.imageViewUserMood);
            trash = itemView.findViewById(R.id.imageViewDelete);
            this.listen = listen;

            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listen.deleteUser(position);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listen.gotoProfile(position);
                }
            });
        }
    }

    interface userAdp{
        void deleteUser(int i);
        void gotoProfile(int i);
    }
}
