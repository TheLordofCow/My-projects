package edu.uncc.assessment02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uncc.assessment02.models.User;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        UserHolder viewHolder = new UserHolder(view, listen);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = users.get(position);
        holder.userName.setText(user.getName());
        holder.age.setText(user.getAge()+" Years old");
        holder.position = holder.getAdapterPosition();
        holder.state.setText(user.getState().getName() + ", " + user.getState().getAbbreviation());
        holder.credScore.setText(user.getCreditScore()+"");

        if(user.getCreditScore() < 580){
            holder.cScore.setImageDrawable(context.getDrawable(R.drawable.poor));
        } else if (user.getCreditScore() < 670) {
            holder.cScore.setImageDrawable(context.getDrawable(R.drawable.fair));
        } else if (user.getCreditScore() < 740) {
            holder.cScore.setImageDrawable(context.getDrawable(R.drawable.good));
        } else if (user.getCreditScore() < 800) {
            holder.cScore.setImageDrawable(context.getDrawable(R.drawable.very_good));
        } else if (user.getCreditScore() < 851) {
            holder.cScore.setImageDrawable(context.getDrawable(R.drawable.excellent));
        }
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public static class UserHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView age;
        TextView state;
        TextView credScore;
        ImageView cScore;
        ImageView trash;
        int position;
        userAdp listen;
        public UserHolder(@NonNull View itemView, userAdp listen) {
            super(itemView);
            userName = itemView.findViewById(R.id.textViewUserName);
            age = itemView.findViewById(R.id.textViewUserAge);
            cScore = itemView.findViewById(R.id.imageViewCreditScore);
            trash = itemView.findViewById(R.id.imageViewDelete);
            state = itemView.findViewById(R.id.textViewUserState);
            credScore = itemView.findViewById(R.id.textViewCreditScore);
            this.listen = listen;

            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listen.deleteUser(position);
                }
            });
        }
    }

    interface userAdp{
        void deleteUser(int i);
    }
}

