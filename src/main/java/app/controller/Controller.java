package app.controller;


import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.dto.MusicGroupDTO;
import app.entity.MusicGroup;
import app.repository.MusicGroupRepository;
import app.service.IMusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class Controller {

    private IMusicService musicService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public Controller(IMusicService musicService, MusicGroupRepository musicGroupRepository){
        this.musicService=musicService;
    }

    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
    public String get(@PathVariable String value){
        return value;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveComp(@RequestBody @Valid CompositionDTO cdto){
        musicService.saveComp(cdto);
    }

    @RequestMapping(value="/saveexec", method = RequestMethod.POST)
    public void saveExec(@RequestBody @Valid ExecutorDTO edto){
        musicService.saveExec(edto);
    }

    @RequestMapping(value="/getmusic", method = RequestMethod.GET)
    public MusicGroupDTO getMusic(@RequestParam("id") Integer id){
        return musicService.getMusic(id);
    }

}
