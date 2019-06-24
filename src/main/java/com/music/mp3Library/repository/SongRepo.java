/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.music.mp3Library.repository;

import com.music.mp3Library.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thodo
 */
@Repository
public interface SongRepo extends JpaRepository<Song, Integer>{
    
}
