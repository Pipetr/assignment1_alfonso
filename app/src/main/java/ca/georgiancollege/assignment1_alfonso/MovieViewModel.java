package ca.georgiancollege.assignment1_alfonso;

import android.media.Image;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieViewModel extends ViewModel {

    MovieModel movieModel = new MovieModel();
    private final MutableLiveData<MovieModel> movieData = new MutableLiveData<MovieModel>();

    public MutableLiveData<MovieModel> getMovieData() {
        return movieData;
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

                JSONObject json = null;
                try{
                    json = new JSONObject(responseData);
                    String title = json.getString("Title");
                    String year = json.getString("Year");
                    String id = json.getString("imdbID");
                    String poster = json.getString("imdbID");

                    movieModel.setTitle(title);
                    movieModel.setYear(year);
                    movieModel.setImdbID(id);
                    movieModel.setPoster(poster);

                    movieData.postValue(movieModel);

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
