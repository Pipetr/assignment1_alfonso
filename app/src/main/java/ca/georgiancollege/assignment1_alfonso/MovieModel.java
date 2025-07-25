package ca.georgiancollege.assignment1_alfonso;

import android.net.Uri;

public class MovieModel {
    private String Title;

    private String Year;

    private Uri Poster;

    private String imdbID;

    // constructor
    public MovieModel() {
    }

    public MovieModel(String title, String year, Uri poster, String imdbID) {
        Title = title;
        Year = year;
        Poster = poster;
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public Uri getPoster() {
        return Poster;
    }

    public void setPoster(Uri poster) {
        Poster = poster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
