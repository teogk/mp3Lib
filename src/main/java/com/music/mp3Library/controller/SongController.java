/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.music.mp3Library.controller;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.music.mp3Library.dao.SongDao;
import com.music.mp3Library.model.Song;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SongController {

    @Autowired
    SongDao songDao;

    @GetMapping(value = "view")
    public String getSongs(ModelMap mm) {
        List<Song> songs = songDao.getAllSongs();
        mm.addAttribute("songs", songs);
        return "view";
    }

    @GetMapping(value = "insert")
    public String insertSong(ModelMap mm) {
        Song song = new Song();
        mm.addAttribute("song", song);
        return "insertSong";
    }

    @PostMapping(value = "doinsertSong")
    public String doinsertSong(@ModelAttribute Song song, @RequestParam(value = "mp3") MultipartFile myMP3) {

        try {
            song.setFilename(myMP3.getOriginalFilename());
            try {
                Mp3File mp3file = new Mp3File("C:\\Users\\thodo\\Downloads\\One Love.mp3");
                if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    song.setTitle(id3v1Tag.getTitle());
                    song.setAlbum(id3v1Tag.getAlbum());
                    song.setArtist(id3v1Tag.getArtist());
                } else if (mp3file.hasId3v2Tag()) {
                    ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                    song.setTitle(id3v2Tag.getTitle());
                    song.setAlbum(id3v2Tag.getAlbum());
                    song.setArtist(id3v2Tag.getArtist());
                }

            } catch (UnsupportedTagException | InvalidDataException ex) {
                Logger.getLogger(SongController.class.getName()).log(Level.SEVERE, null, ex);
            }

            song.setFile(myMP3.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        songDao.insert(song);
        return "redirect:/view/";
    }

    @GetMapping(value = "download/{id}", produces = MediaType.ALL_VALUE)
    public @ResponseBody
    byte[] downloadFile(ModelMap mm, @PathVariable("id") int id) {
        Song song = songDao.getSong(id);
        return song.getFile();
    }

}
