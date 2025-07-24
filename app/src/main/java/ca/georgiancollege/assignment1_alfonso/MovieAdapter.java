package ca.georgiancollege.assignment1_alfonso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<MovieModel> movieList;
    private Context context;

    public MovieAdapter(List<MovieModel> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(movieView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.movieTitleTextView.setText(movie.getTitle());
        holder.movieDirectorTextView.setText(movie.getDirector());
        holder.movieRatedTextView.setText(movie.getRated());
        holder.movieReleasedTextView.setText(movie.getYear());


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
