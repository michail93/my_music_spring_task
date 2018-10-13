package app.controller;

import app.dto.ExecutorDTO;
import app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "executor")
public class ExecutorController {

    private IMusicService musicService;

    @Autowired
    public ExecutorController(IMusicService musicService){
        this.musicService =  musicService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExecutorDTO getExec(@PathVariable Integer id){
        return musicService.getExec(id);
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public void saveExec(@RequestBody @Valid ExecutorDTO ex){
        musicService.saveExec(ex);
    }

}
