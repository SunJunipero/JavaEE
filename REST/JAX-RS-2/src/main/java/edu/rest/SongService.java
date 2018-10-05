package edu.rest;

import edu.model.Song;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/service")
public class SongService {
    static Map<String, Song> songs = new HashMap<String, Song>();

    @PostConstruct
    public void init(){
        songs.put("1", new Song("Knee socks", 342, 23));
        songs.put("2", new Song("Arabella", 316, 12));
        songs.put("3", new Song("One for the road", 196, 8));
    }

    @GET
    @Path("/song")
    public Song getById(@QueryParam("id") String id){
        return songs.get(id);
    }

    @GET
    @Path("/songs")
    @Produces(MediaType.APPLICATION_XML)
    public List<Song> getAll(){
        return new ArrayList<>(songs.values());
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_XML)
    public List<Song> add(@FormParam("name") String name, @FormParam("duration") int duration){
        int next = songs.size() + 1;
        songs.put(String.valueOf(next), new Song(name, duration, next));
        return getAll();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public List<Song> add(Song song){
        int next = songs.size() + 1;
        songs.put(String.valueOf(next), song);
        return getAll();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Song> delete(@PathParam("id") String id){
        songs.remove(id);
        return getAll();
    }
}
