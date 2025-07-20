package ca.georgiancollege.assignment1_alfonso;

public class MovieModel {
    // attributes
//    Title
//    Director
//    Rated
//    Released
    private String Title;
    private String Director;
    private String Rated;
    private String Released;

    // constructor
    public MovieModel() {
    }

    // getters and setters

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
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
}
