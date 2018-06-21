package pojos;

import java.util.Objects;

public class Tag {
    private Integer userId;
    private Integer movieId;
    private String tag;
    private Long timestamp;

    public Integer getUserId() {
        return userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getTag() {
        return tag;
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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag1 = (Tag) o;
        return Objects.equals(userId, tag1.userId) &&
                Objects.equals(movieId, tag1.movieId) &&
                Objects.equals(tag, tag1.tag) &&
                Objects.equals(timestamp, tag1.timestamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, movieId, tag, timestamp);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                ", tag='" + tag + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
