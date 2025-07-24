package ca.georgiancollege.assignment1_alfonso;

import android.net.Uri;

public class MovieDetails {

    private String Title;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Plot;
    private Uri Poster;

    // constructor


    public MovieDetails() {
    }

    public MovieDetails(String title, String rated, String released, String runtime, String plot, Uri poster) {
        Title = title;
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
