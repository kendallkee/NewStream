package newstream.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import newstream.entity.Song;

public interface SongDao extends JpaRepository<Song, Long> {
	 List<Song> findByGenre(String genre);
	}

