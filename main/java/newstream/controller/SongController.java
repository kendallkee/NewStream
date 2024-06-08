package newstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import newstream.controller.model.SongData;
import newstream.service.NewStreamService;

@RestController
@RequestMapping("/newstream")
@Slf4j
public class SongController {

	@Autowired
	private NewStreamService newStreamService;

	@PostMapping("/songs")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<SongData> addSong(@RequestBody SongData songData) {
		log.info("Adding song {}", songData);
		return ResponseEntity.ok(newStreamService.addSong(songData));
	}

	@GetMapping("/songs")
	public ResponseEntity<List<SongData>> getAllSongs() {
		return ResponseEntity.ok(newStreamService.getAllSongs());
	}

	@GetMapping(params = "genre")
	public ResponseEntity<List<SongData>> getSongsByGenre(@RequestParam String genre) {
		return ResponseEntity.ok(newStreamService.getSongsByGenre(genre));
	}

	@GetMapping("/songs/{songId}")
	public ResponseEntity<SongData> getSongById(@PathVariable Long songId) {
		SongData songData = newStreamService.getSongById(songId);
		return songData != null ? ResponseEntity.ok(songData) : ResponseEntity.notFound().build();
	}

	@PutMapping("/songs/{songId}")
	public ResponseEntity<SongData> updateSong(@PathVariable Long songId, @RequestBody SongData songData) {
		SongData updatedSongData = newStreamService.updateSong(songId, songData);
		return updatedSongData != null ? ResponseEntity.ok(updatedSongData) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/songs/{songId}")
	public ResponseEntity<Void> deleteSong(@PathVariable Long songId) {
		newStreamService.deleteSong(songId);
		return ResponseEntity.noContent().build();
	}
}
