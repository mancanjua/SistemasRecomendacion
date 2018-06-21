package pojos;

import java.util.Objects;

public class Rating {
    private Integer userId;
    private Integer movieId;
    private Double rating;
    private Long timestamp;

    public Integer getUserId() {
        return userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Double getRating() {
        return rating;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(userId, rating1.userId) &&
                Objects.equals(movieId, rating1.movieId) &&
                Objects.equals(rating, rating1.rating) &&
                Objects.equals(timestamp, rating1.timestamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, movieId, rating, timestamp);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                '}';
    }
}
