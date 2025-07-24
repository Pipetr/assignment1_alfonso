package ca.georgiancollege.assignment1_alfonso;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ca.georgiancollege.assignment1_alfonso.databinding.MovieDetailsBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieDetailsActivity extends AppCompatActivity {
    MovieDetailsBinding binding;
    private final String API_KEY = "62703845";

    @Override
    protected void onCreate(Bundle savedOnstanceState){
        super.onCreate(savedOnstanceState);

        binding = MovieDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String imdbID = getIntent().getStringExtra("imdbID");

        if(imdbID != null){fetchMovieDetails(imdbID);}
        binding.btnBack.setOnClickListener(v -> finish());
    }

    private void fetchMovieDetails(String imdbID) {
        String url = "https://www.omdbapi.com/?apikey="+ API_KEY +"&type=movie&i=" + imdbID +"&plot=short";
        ApiClient.get(url, new Callback(){
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("TAG", "onFailure: " + e.getMessage());
                runOnUiThread(() -> Toast.makeText(MovieDetailsActivity.this, "Network error", Toast.LENGTH_SHORT).show());
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                Log.d("TAG", "onResponse: " + responseData);
                JSONObject json = null;
                try {
                    json = new JSONObject(responseData);
                    String title = json.getString("Title");
                    String rating = "Rated: " + json.getString("Rated");
                    String released = "Released: " + json.getString("Released");
                    String duration = "Duration: " + json.getString("Runtime");
                    String plot = "Plot: " + json.getString("Plot");
                    Uri poster = Uri.parse(json.getString("Poster"));

                    runOnUiThread(() -> {
                            binding.textTitle.setText(title);
                            binding.textRated.setText(rating);
                            binding.textReleased.setText(released);
                            binding.textRuntime.setText(duration);
                            binding.textPlot.setText(plot);
                            if(poster == null){
                                binding.imagePoster.setImageResource(R.drawable.broken_image_48);
                            }
                            else{
                                Picasso.get()
                                        .load(poster)
                                        .placeholder(R.drawable.broken_image_48)
                                        .into(binding.imagePoster);
                            }

                    });


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        });
    }
}
