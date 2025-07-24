package ca.georgiancollege.assignment1_alfonso;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView movieImageView;
    public TextView movieTitleTextView;
    public TextView movieDirectorTextView;
    public TextView movieRatedTextView;
    public TextView movieReleasedTextView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImageView = itemView.findViewById(R.id.movieImageView);
        movieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
        movieDirectorTextView = itemView.findViewById(R.id.movieDirectorTextView);
        movieRatedTextView = itemView.findViewById(R.id.movieRatedTextView);
        movieReleasedTextView = itemView.findViewById(R.id.movieReleasedTextView);

    }
}
