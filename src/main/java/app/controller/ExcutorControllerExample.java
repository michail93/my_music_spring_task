//package app.controller;
//
//
//import app.dto.CompositionDTO;
//import app.dto.ExecutorDTO;
//import app.entity.MusicGroup;
//import app.repository.MusicGroupRepository;
//import app.service.IMusicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//
////@RestController
////@Validated
////public class ExcutorController {
////
////    private IMusicService musicService;
////    private MusicGroupRepository musicGroupRepository;
////
////    @Autowired
////    public ExcutorController(IMusicService musicService, MusicGroupRepository musicGroupRepository){
////        this.musicService=musicService;
////        this.musicGroupRepository=musicGroupRepository;
////    }
////
////
////    @RequestMapping(value = "", method = RequestMethod.POST)
////    public void saveComp(@RequestBody @Valid CompositionDTO cdto){
////        musicService.saveComp(cdto);
////    }
////
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public void getComp(@PathVariable @NotNull Long id){
//        musicService.getComp(id);
//    }
////
////    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
////    public void updateComp(@PathVariable @NotNull Long id, @RequestBody @Valid CompositionDTO cdto){
////        musicService.updateComp(id, cdto);
////    }
////
////    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
////    public void getComp(@PathVariable @NotNull Long id){
////        musicService.deleteComp(id);
////    }
////
////
////}
