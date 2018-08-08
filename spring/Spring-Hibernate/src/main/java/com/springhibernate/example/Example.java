package com.springhibernate.example;

import com.springhibernate.example.model.Genre;
import com.springhibernate.example.service.GenreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.*;

public class Example {
    public static void main(String[] args)  {

//        File file = new File("classpath: springExample.xml");
//        System.out.println(file.exists());

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        //ApplicationContext context = new GenericXmlApplicationContext("/home/kostya/IdeaProjects/JavaEE/spring/Spring-Hibernate/src/main/resources/springExample.xml");
        GenreService genreService = (GenreService) context.getBean("genreService");

       // test1(genreService);
        //test2(genreService);
        //test3(genreService);
        //test4(genreService);
        test5(genreService);



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

    public static void test4 (GenreService genreService){
            genreService.readOnly("read only");
    }

    //SpringJDBC
    public static void test5 (GenreService genreService){
        Genre read_only = genreService.getGenre("read only");
        genreService.deleteGenre(read_only);

    }
}
