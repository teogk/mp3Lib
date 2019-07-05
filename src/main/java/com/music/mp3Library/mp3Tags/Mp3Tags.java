/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.music.mp3Library.mp3Tags;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author thodo
 */
@Component
public class Mp3Tags {

    public String getTitle(String path) {
        String title = null;
        try {
            Mp3File mp3file = new Mp3File(path);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                title = id3v1Tag.getTitle();
            } else if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                title = id3v2Tag.getTitle();
            }
        } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
            Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
        }
        return title;
    }

    public String getAlbum(String path) {
        String album = null;
        try {
            Mp3File mp3file = new Mp3File(path);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                album = id3v1Tag.getAlbum();
            } else if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                album = id3v2Tag.getAlbum();
            }
        } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
            Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
        }
        return album;
    }

    public String getArtist(String path) {
        String artist = null;
        try {
            Mp3File mp3file = new Mp3File(path);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                artist = id3v1Tag.getArtist();
            } else if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                artist = id3v2Tag.getArtist();
            }
        } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
            Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artist;
    }
}
