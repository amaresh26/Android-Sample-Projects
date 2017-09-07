package in.apptozee.calc.calc.movieinfo.model;

import java.io.Serializable;

/**
 * Created by amareshjana on 27/03/17.
 */

public class MovieModel implements Serializable {
    private String movieName;
    private String movieDesc;
    private String movieCategory;
    private String movieReleaseDate;
    private String movieAwards;
    private String movieRating;
    private String movieImage;
    private String castId;


    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public void setMovieAwards(String movieAwards) {
        this.movieAwards = movieAwards;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public void setCastId(String castId) {
        this.castId = castId;
    }

    public MovieModel(String movieName, String movieDesc, String movieCategory, String movieReleaseDate,
                      String movieAwards, String movieRating, String movieImage, String castId) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.movieCategory = movieCategory;
        this.movieReleaseDate = movieReleaseDate;
        this.movieAwards = movieAwards;
        this.movieRating = movieRating;
        this.movieImage = movieImage;
        this.castId = castId;

    }

    public MovieModel() {
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public String getMovieAwards() {
        return movieAwards;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public String getCastId() {
        return castId;
    }
}
