package ca.georgiancollege.assignment1_alfonso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

import ca.georgiancollege.assignment1_alfonso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        viewModel.getMovieData().observe(this, movieData -> {
            Log.d("TAG", "Update view");
            binding.txtViewTitle.set
            binding.tvDirector.setText(movieData.getDirector());
            binding.tvRating.setText(movieData.getRated());
            binding.tvYear.setText(movieData.getYear());
        });

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the movie title from the input field
                String movieTitle = Objects.requireNonNull(binding.txtInSearch.getText()).toString().trim();
                // Check if the input is not empty
                if (!movieTitle.isEmpty()) {
                    // Call the ViewModel to search for the movie
                    viewModel.SearchMovie(movieTitle);
                } else {
                    // Show an error message or handle empty input
                    binding.txtInSearch.setError("Please enter a movie title");
                }
            }
        });

    }
}