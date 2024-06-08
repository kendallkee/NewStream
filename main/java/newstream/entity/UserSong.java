package newstream.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user_songs")
public class UserSong {
		
	@EmbeddedId
	private UserSongId id = new UserSongId();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("songId")
    private Song song;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date likeDate;

    // Default constructor
    public UserSong() {}

    // Parameterized constructor
    public UserSong(User user, Song song, Date likeDate) {
        this.user = user;
        this.song = song;
        this.likeDate = likeDate;
        this.id = new UserSongId(user.getUserId(), song.getSongId());
    }

    // Getters and Setters
    public UserSongId getId() {
        return id;
    }

    public void setId(UserSongId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSong userSong = (UserSong) o;
        return Objects.equals(id, userSong.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Override toString
    @Override
    public String toString() {
        return "UserSong{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", song=" + song.getTitle() +
                ", likeDate=" + likeDate +
                '}';
    }
}
