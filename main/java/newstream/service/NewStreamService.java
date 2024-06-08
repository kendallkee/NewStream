package newstream.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import newstream.controller.model.SongData;
import newstream.controller.model.UserData;
import newstream.dao.SongDao;
import newstream.dao.UserDao;
import newstream.entity.Song;
import newstream.entity.User;

@Service
public class NewStreamService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SongDao songDao;
    

    @Transactional(readOnly = false)
    public UserData saveUser(UserData userData) {
        User user = userData.toUser();
        User dbUser = userDao.save(user);
        return new UserData(dbUser);
    }

    @Transactional(readOnly = false)
    public SongData addSong(SongData songData) {
        Song song = songData.toSong();
        Song savedSong = songDao.save(song);
        return new SongData(savedSong);
    }

    @Transactional(readOnly = true)
    public List<SongData> getAllSongs() {
        return songDao.findAll().stream().map(SongData::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongData> getSongsByGenre(String genre) {
        return songDao.findByGenre(genre).stream().map(SongData::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SongData getSongById(Long songId) {
        return songDao.findById(songId).map(SongData::new).orElse(null);
    }

    @Transactional(readOnly = false)
    public SongData updateSong(Long songId, SongData songData) {
        return songDao.findById(songId).map(song -> {
            song.setTitle(songData.getTitle());
            song.setArtist(songData.getArtist());
            song.setGenre(songData.getGenre());
            song.setReleaseDate(songData.getReleaseDate());
            Song updatedSong = songDao.save(song);
            return new SongData(updatedSong);
        }).orElse(null);
    }

    @Transactional(readOnly = false)
    public void deleteSong(Long songId) {
        songDao.deleteById(songId);
    }
    
}

