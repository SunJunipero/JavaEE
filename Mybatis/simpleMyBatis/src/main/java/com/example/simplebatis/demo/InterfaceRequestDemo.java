package com.example.simplebatis.demo;

import com.example.simplebatis.Song;
import com.example.simplebatis.SongsDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

public class InterfaceRequestDemo {
    public static void main(String[] args) throws IOException {
        String config = "Configuration.xml";
        Reader reader = Resources.getResourceAsReader(config);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sessionFactory.openSession();

        SongsDao dao = sqlSession.getMapper(SongsDao.class);

        System.out.println("Songs dao " + dao.getClass().getCanonicalName());

        getAllSongs(dao);

        Song song = new Song();
        Random random = new Random();
        song.setSong_name("i-face song " + random.nextInt(100));
        dao.insert(song);
        sqlSession.commit();

        System.out.println("id song - " + song.getSong_id());

        getAllSongs(dao);

        song.setSong_name("update i-face song" + song.getSong_name());
        dao.update(song);
        sqlSession.commit();
        getAllSongs(dao);

        dao.deleteSongById(song.getSong_id());
        sqlSession.commit();
        getAllSongs(dao);

    }

    private static void getAllSongs(SongsDao dao) {
        System.out.println("==========");
        List<Song> songs = dao.getSongs();
        System.out.println("size = " + songs.size());
        songs.forEach(song -> {
            System.out.print(song.getSong_id()+" ");
            System.out.println(song.getSong_name());
        });

        System.out.println("==========");
    }
}
