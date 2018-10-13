package app.controller;

import app.dto.CompositionDTO;
import app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "composition")
public class CompositionController {

    private IMusicService musicService;

    @Autowired
    public CompositionController(IMusicService musicService){
        this.musicService=musicService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CompositionDTO get(@PathVariable Integer id){
        return musicService.getComposition(id);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveComp(@RequestBody CompositionDTO cdto){
        musicService.saveComp(cdto);
    }

}
