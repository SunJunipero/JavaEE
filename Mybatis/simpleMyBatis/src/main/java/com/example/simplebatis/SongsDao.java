package com.example.simplebatis;


import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongsDao {
    Song getSongById(Integer id);
    List<Song> getSongs();
    void insert(Song song);
    void update(Song song);
    void deleteSongById(Integer id);
}
