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
import com.music.mp3Library.mp3Tags.Mp3Tags;
import java.io.File;
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
    @Autowired
    Mp3Tags mp3Tags;

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

        File mp3File;
        try {
            mp3File = multipartToFile(myMP3, myMP3.getName());
            String path = mp3File.getAbsolutePath();
            song.setFilename(myMP3.getOriginalFilename());
            song.setTitle(mp3Tags.getTitle(path));
            song.setAlbum(mp3Tags.getAlbum(path));
            song.setArtist(mp3Tags.getArtist(path));
        } catch (IllegalStateException | IOException ex) {
            Logger.getLogger(SongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
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

    public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

}
