package app.service;

import app.dto.AlbumDTO;
import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.dto.MusicGroupDTO;
import app.entity.MusicGroup;

import javax.persistence.criteria.CriteriaBuilder;

public interface IMusicService {
    void saveComp(CompositionDTO cdto);
    CompositionDTO getComposition(Integer id);


    void saveExec(ExecutorDTO edto);
    ExecutorDTO getExec(Integer id);


    void saveMusicGroup(MusicGroupDTO mgdto);
    MusicGroupDTO getMusic(Integer id);


    AlbumDTO getAlbum(Integer id);
    void saveAlbum(AlbumDTO adto);



}
