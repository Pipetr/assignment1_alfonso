package ca.georgiancollege.assignment1_alfonso;

import android.net.Uri;

public class MovieDetails {
    /*
    "Title": "Madagascar",
    "Year": "2005",
    "Rated": "PG",
    "Released": "27 May 2005",
    "Runtime": "86 min",
    "Plot": "A group of zoo animals decide to escape from their home and travel to Madagascar.",
    "Poster": "https://m.media-amazon.com/images/M/MV5BMTQ1NjY2NjY4OF5BMl5BanBnXkFtZTcwMjE3NzYyMQ@@._V1_SX300.jpg",
    * */
    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Plot;
    private Uri Poster;

    // constructor


    public MovieDetails() {
    }

    public MovieDetails(String title, String year, String rated, String released, String runtime, String plot, Uri poster) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Plot = plot;
        Poster = poster;
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

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public Uri getPoster() {
        return Poster;
    }

    public void setPoster(Uri poster) {
        Poster = poster;
    }
}
