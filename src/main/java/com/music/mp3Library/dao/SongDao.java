
package com.music.mp3Library.dao;

import com.music.mp3Library.model.Song;
import com.music.mp3Library.repository.SongRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SongDao {

    @Autowired
    SongRepo songRepo;

    public void insert(Song s) {
        songRepo.save(s);
    }

    public List<Song> getAllSongs() {
        List<Song> songs = songRepo.findAll();
        return songs;
    }

    public Song getSong(int id) {
        Song song = songRepo.getOne(id);
        return song;
    }

}
