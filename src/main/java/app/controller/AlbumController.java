package app.controller;

import app.dto.AlbumDTO;
import app.entity.Album;
import app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "album")
public class AlbumController {

    private IMusicService musicService;

    @Autowired
    public AlbumController(IMusicService musicService){
        this.musicService=musicService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AlbumDTO getAlbum(@PathVariable Integer id ){
        return musicService.getAlbum(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveAlbum(@RequestBody @Valid AlbumDTO adto){

    }

}
