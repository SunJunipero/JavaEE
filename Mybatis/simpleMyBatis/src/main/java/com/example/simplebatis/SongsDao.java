package com.example.simplebatis;


import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SongsDao {
    @Results({
            @Result(property = "song_id", column = "id"),
            @Result(property = "song_name", column = "name")
    })
    @Select("select id, name from songs.public.song where id = #{song_id}")
    Song getSongById(Integer id);
    @Results({
            @Result(property = "song_id", column = "id"),
            @Result(property = "song_name", column = "name")
    })
    @Select("select id, name from songs.public.song")
    List<Song> getSongs();
    @Insert("insert into songs.public.song (name) values (#{song_name})")
    @Options(useGeneratedKeys = true, keyProperty = "song_id")
    void insert(Song song);
    @Update("update songs.public.song set name = #{song_name} where id = #{song_id}")
    void update(Song song);
    @Delete("delete from songs.public.song where id = #{song_id}")
    void deleteSongById(Integer id);
}
