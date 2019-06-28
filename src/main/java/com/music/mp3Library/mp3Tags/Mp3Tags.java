/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.music.mp3Library.mp3Tags;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v1;
import org.farng.mp3.id3.AbstractID3v2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class Mp3Tags {

   public String getTitle(File sourceFile) {
       String title = null;
       try {
           MP3File mp3file = new MP3File(sourceFile);
           if (mp3file.hasID3v2Tag()) {
               AbstractID3v2 tag = mp3file.getID3v2Tag();
               title = tag.getSongTitle();
               tag.setAlbumTitle("Album");
               tag.setLeadArtist("Artist");

           } else if (mp3file.hasID3v1Tag()) {
               AbstractID3v1 tag = mp3file.getID3v1Tag();
               title = tag.getSongTitle();
               tag.setAlbumTitle("Album");
               tag.setLeadArtist("Artist");
               
           }
       } catch (IOException | TagException ex) {
           Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
       }
       return title;
   }

   public String getAlbum(File sourcefile) {
       String album = null;
       try {
           MP3File mp3file = new MP3File(sourcefile);
           if (mp3file.hasID3v2Tag()) {
               AbstractID3v2 tag = mp3file.getID3v2Tag();
               album = tag.getAlbumTitle();

           } else if (mp3file.hasID3v1Tag()) {
               AbstractID3v1 tag = mp3file.getID3v1Tag();
               album = tag.getAlbumTitle();
           }

       } catch (IOException | TagException ex) {
           Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
       }
       return album;
   }

   public String getArtist(File sourcefile) {
       String artist = null;
       try {
           MP3File mp3file = new MP3File(sourcefile);
           if (mp3file.hasID3v2Tag()) {
               AbstractID3v2 tag = mp3file.getID3v2Tag();
               artist = tag.getLeadArtist();

           } else if (mp3file.hasID3v1Tag()) {
               AbstractID3v1 tag = mp3file.getID3v1Tag();
               artist = tag.getLeadArtist();
           }
       } catch (IOException | TagException ex) {
           Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
       }
       return artist;
   }
    public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
       File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
       multipart.transferTo(convFile);
       return convFile;
   }

}