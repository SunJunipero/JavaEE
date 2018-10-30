package com.example.formmvc.controller;

import com.example.formmvc.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @RequestMapping(value = "/song", method = RequestMethod.GET)
    public ModelAndView song(){
        return new ModelAndView("song", "command", new Song());
    }

    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    public String addSong(@ModelAttribute("SpringWeb")Song song, ModelMap map){
        map.addAttribute("id", song.getId());
        map.addAttribute("name", song.getName());
        map.addAttribute("artist", song.getArtist());
        return "result";
    }
}
