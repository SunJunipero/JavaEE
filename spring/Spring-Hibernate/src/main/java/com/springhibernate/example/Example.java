package com.springhibernate.example;

import com.springhibernate.example.model.Genre;
import com.springhibernate.example.service.GenreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        GenreService genreService = (GenreService) context.getBean("genreService");

       // test1(genreService);
        //test2(genreService);
        test3(genreService);

    }

    public static void test1 (GenreService genreService){
        Genre lol_genre = new Genre("lol genre");
        genreService.createGenre(lol_genre);
    }

    public static void test2 (GenreService genreService){
        Genre wow_genre = new Genre("wow genre");
        genreService.createGenre(wow_genre);

        Genre wow_genre1 = new Genre("wow genre1");
        genreService.createGenre(wow_genre1);
    }


    public static void test3 (GenreService genreService){
        Genre wow_genre = genreService.getGenre("wow genre");
        genreService.deleteGenre(wow_genre);
    }
}
