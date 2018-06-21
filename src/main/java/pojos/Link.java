package pojos;

import java.util.Objects;

public class Link {
    private Integer movieId;
    private Integer imdbId;
    private Integer tmdbId;

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getImdbId() {
        return imdbId;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setImdbId(Integer imdbId) {
        this.imdbId = imdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(movieId, link.movieId) &&
                Objects.equals(imdbId, link.imdbId) &&
                Objects.equals(tmdbId, link.tmdbId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(movieId, imdbId, tmdbId);
    }

    @Override
    public String toString() {
        return "Link{" +
                "movieId=" + movieId +
                ", imdbId=" + imdbId +
                ", tmdbId=" + tmdbId +
                '}';
    }
}
