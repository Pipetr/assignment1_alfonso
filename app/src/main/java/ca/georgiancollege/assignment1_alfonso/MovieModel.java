package ca.georgiancollege.assignment1_alfonso;

import android.media.Image;

public class MovieModel {
    private String Title;

    private String Year;

    private Image Poster;

    private String imdbID;

    // constructor
    public MovieModel() {
    }

    public MovieModel(String title, String year, Image poster, String imdbID) {
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

    public Image getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
