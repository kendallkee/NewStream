package newstream.controller.model;

import newstream.entity.Song;

public class SongData {
    private Long songId;
    private String title;
    private String artist;
    private String genre;
    private String releaseDate;

    // Constructors, getters, and setters
    public SongData() {}

    public SongData(Song song) {
        this.songId = song.getSongId();
        this.title = song.getTitle();
        this.artist = song.getArtist();
        this.genre = song.getGenre();
        this.releaseDate = song.getReleaseDate();
    }

    public Song toSong() {
        if (this.releaseDate == null || this.releaseDate.isEmpty()) {
            throw new IllegalArgumentException("Release date cannot be null or empty");
        }

        Song song = new Song();
        song.setSongId(this.songId);
        song.setTitle(this.title);
        song.setArtist(this.artist);
        song.setGenre(this.genre);
        song.setReleaseDate(this.releaseDate);
        return song;
    }

    // Getters and Setters
    public Long getSongId() { return songId; }
    public void setSongId(Long songId) { this.songId = songId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

	

	
}
