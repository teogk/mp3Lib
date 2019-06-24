/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.music.mp3Library.controller;

import com.music.mp3Library.dao.SongDao;
import com.music.mp3Library.model.Song;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String doinsertSong(ModelMap mm, @ModelAttribute Song song, @RequestParam(value = "myfile") MultipartFile mf) {
        song.setFilename(mf.getOriginalFilename());
        try {
            song.setFile(mf.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        songDao.insert(song);
        return "redirect:/view/";
    }

}
