package newstream.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserSongId implements Serializable {
	
	/**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;

    private Long userId;
    private Long songId;

    // Default constructor
    public UserSongId() {}

    // Parameterized constructor
    public UserSongId(Long userId, Long songId) {
        this.userId = userId;
        this.songId = songId;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    // Override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSongId that = (UserSongId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(songId, that.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, songId);
    }
}
