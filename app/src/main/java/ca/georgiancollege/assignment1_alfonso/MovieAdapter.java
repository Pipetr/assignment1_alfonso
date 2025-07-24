package ca.georgiancollege.assignment1_alfonso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<MovieModel> movieList;
    Context context;

    public MovieAdapter(List<MovieModel> movieList) {
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        if(movie.getPoster()!= null){
            Picasso.get()
                    .load(movie.getPoster().toString())
                    .placeholder(R.drawable.broken_image_48)
                    .into(holder.image);
        }else {
            holder.image.setImageResource(R.drawable.broken_image_48);
        }
        holder.released.setText(movie.getYear());
        holder.id.setText(movie.getImdbID());
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("imdbID", movie.getImdbID());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateData(List<MovieModel> movieModels) {
        this.movieList.clear();
        this.movieList.addAll(movieModels);
        notifyDataSetChanged();
    }
}
