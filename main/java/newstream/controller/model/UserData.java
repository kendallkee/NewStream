package newstream.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import newstream.entity.Song;
import newstream.entity.SongReview;
import newstream.entity.User;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Set<SongReviewData> songReviews = new HashSet<>();
    private Set<SongData> likedSongs = new HashSet<>();

    public UserData(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();

        for (SongReview songReview : user.getSongReviews()) {
            this.songReviews.add(new SongReviewData(songReview));
        }

        for (Song song : user.getLikedSongs()) {
            this.likedSongs.add(new SongData(song));
        }
    }

    public User toUser() {
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        for (SongReviewData songReviewData : songReviews) {
            user.getSongReviews().add(songReviewData.toSongReview());
        }

        for (SongData songData : likedSongs) {
            user.getLikedSongs().add(songData.toSong());
        }

        return user;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SongReviewData {
        private Long reviewId;
        private SongData song;
        private int rating;
        private String comment;

        public SongReviewData(SongReview songReview) {
            this.reviewId = songReview.getReviewId();
            this.song = new SongData(songReview.getSong());
            this.rating = songReview.getRating();
            this.comment = songReview.getComment();
        }

        public SongReview toSongReview() {
            SongReview songReview = new SongReview();
            songReview.setReviewId(reviewId);
            songReview.setSong(song.toSong());
            songReview.setRating(rating);
            songReview.setComment(comment);
            return songReview;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SongData {
        private Long songId;
        private String title;
        private String artist;
        private String genre;
        private String releaseDate;
        private Set<SongReviewData> songReviews = new HashSet<>();

        public SongData(Song song) {
            this.songId = song.getSongId();
            this.title = song.getTitle();
            this.artist = song.getArtist();
            this.genre = song.getGenre();
            this.releaseDate = song.getReleaseDate();

            for (SongReview songReview : song.getSongReviews()) {
                this.songReviews.add(new SongReviewData(songReview));
            }
        }

        public Song toSong() {
            Song song = new Song();
            song.setSongId(songId);
            song.setTitle(title);
            song.setArtist(artist);
            song.setGenre(genre);
            song.setReleaseDate(releaseDate);

            for (SongReviewData songReviewData : songReviews) {
                song.getSongReviews().add(songReviewData.toSongReview());
            }

            return song;
        }
    }
}
