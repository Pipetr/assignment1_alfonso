package ca.georgiancollege.assignment1_alfonso;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.georgiancollege.assignment1_alfonso.databinding.ActivityMainBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView title;
    public TextView released;
    public TextView id;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.moviePoster);
        title = itemView.findViewById(R.id.txtViewTitle);
        released = itemView.findViewById(R.id.tvRelease);
        id = itemView.findViewById(R.id.tvMovieId);
    }
}
