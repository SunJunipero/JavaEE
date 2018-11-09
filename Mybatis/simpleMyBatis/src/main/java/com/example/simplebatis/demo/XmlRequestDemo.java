package com.example.simplebatis.demo;

import com.example.simplebatis.Song;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

public class XmlRequestDemo {

    public static void main(String[] args) throws IOException {
        String config = "Configuration.xml";
        Reader reader = Resources.getResourceAsReader(config);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sessionFactory.openSession();

        try {
            Song song = new Song();
            Random random = new Random();
            song.setSong_name("new song " + String.valueOf(random.nextInt(100)));

            sqlSession.insert("mybatis.SongMapper.insertSong", song);
            sqlSession.commit();

            System.out.println("Song ID" + song.getSong_id());

            getAllSong(sqlSession);

            song.setSong_name("update name " + song.getSong_id());
            sqlSession.update("mybatis.SongMapper.updateSong", song);
            sqlSession.commit();
            getAllSong(sqlSession);

            sqlSession.delete("mybatis.SongMapper.deleteSong", song.getSong_id());
            sqlSession.commit();
            getAllSong(sqlSession);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }

    }

    private static void getAllSong(SqlSession sqlSession) {
        List<Song> songs = sqlSession.selectList("mybatis.SongMapper.getAllSongs");
        System.out.println("===========");
        System.out.println("List of songs");
        songs.forEach(song -> {
            System.out.print(song.getSong_id() + " ");
            System.out.println(song.getSong_name());
        });
        System.out.println("===========");

    }

}
