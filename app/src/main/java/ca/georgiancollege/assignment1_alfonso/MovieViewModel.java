package ca.georgiancollege.assignment1_alfonso;

import android.media.Image;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieViewModel extends ViewModel {

    private final MutableLiveData<List<MovieModel>> movieListLiveData = new MutableLiveData<>();
    MovieModel movieModel = new MovieModel();

    public LiveData<List<MovieModel>> getMovieData() {
        return movieListLiveData;
    }

    public MovieViewModel() {
    }

    public void SearchMovie(String title) {
        // This method will be used to search for a movie by its title
        // The implementation will be added later
        // http://www.omdbapi.com/?apikey=62703845&type=movie&t=Black&plot=short
        String url = "https://www.omdbapi.com/?apikey=62703845&type=movie&s=" + title + "&plot=short";
        ApiClient.get(url, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                String error = e.getMessage();
                Log.d("TAG", error);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("TAG", "onResponse: ");
                assert response.body() != null;
                String responseData = response.body().string();
                Log.d("TAG", "Response: " + responseData);
                List<MovieModel> movieList = new ArrayList<>();
                JSONObject json = null;
                try{
                    json = new JSONObject(responseData);
                    for (int i = 0; i < json.getJSONArray("Search").length(); i++) {
                        JSONObject movieJson = json.getJSONArray("Search").getJSONObject(i);
                        String title = movieJson.getString("Title");
                        String year = movieJson.getString("Year");
                        String id = movieJson.getString("imdbID");
                        Uri poster = movieJson.getString("Poster").equals("N/A") ? null : Uri.parse(movieJson.getString("Poster"));

                        movieList.add(new MovieModel(title, year, poster, id));
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }

                movieListLiveData.postValue(movieList);
            }
        });
    }
}
