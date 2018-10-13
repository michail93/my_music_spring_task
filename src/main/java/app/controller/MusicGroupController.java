package app.controller;

import app.dto.MusicGroupDTO;
import app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
@RequestMapping(value = "musicgroup")
public class MusicGroupController {

    private IMusicService musicService;

    @Autowired
    public MusicGroupController(IMusicService musicService){
        this.musicService=musicService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MusicGroupDTO get(@PathVariable Integer id){
        return musicService.getMusic(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void save(@RequestBody @Valid MusicGroupDTO mgdto){
        musicService.saveMusicGroup(mgdto);
    }

}
