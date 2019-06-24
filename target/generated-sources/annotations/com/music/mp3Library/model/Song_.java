package com.music.mp3Library.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T01:33:45")
@StaticMetamodel(Song.class)
public class Song_ { 

    public static volatile SingularAttribute<Song, String> filename;
    public static volatile SingularAttribute<Song, byte[]> file;
    public static volatile SingularAttribute<Song, String> artist;
    public static volatile SingularAttribute<Song, String> album;
    public static volatile SingularAttribute<Song, Integer> id;
    public static volatile SingularAttribute<Song, String> title;

}