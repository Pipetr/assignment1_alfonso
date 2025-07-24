package ca.georgiancollege.assignment1_alfonso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;
import java.util.Objects;

import ca.georgiancollege.assignment1_alfonso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MovieAdapter myAdapter;
    MovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initialize the ViewModel
        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);

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

        viewModel.getMovieData().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(myAdapter == null){
                    myAdapter = new MovieAdapter(movieModels);
                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.recyclerView.setAdapter(myAdapter);
                }else {
                    // Update the adapter with the new movie list
                    myAdapter.updateData(movieModels);
                }
            }
        });
    }
}