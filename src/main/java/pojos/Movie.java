package pojos;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Movie {
    private Integer movieId;
    private String title;
    private List<Genre> genres;

    public Integer getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(movieId, title, genres);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                '}';
    }
}
