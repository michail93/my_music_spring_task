package app.service;

import app.dto.AlbumDTO;
import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.dto.MusicGroupDTO;
import app.entity.Album;
import app.entity.Composition;
import app.entity.Executor;
import app.entity.MusicGroup;
import app.repository.AlbumRepository;
import app.repository.CompositionRepository;
import app.repository.ExecutorRepository;
import app.repository.MusicGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@Service
public class MusicService implements IMusicService {

    private CompositionRepository compositionRepository;
    private ExecutorRepository executorRepository;
    private MusicGroupRepository musicGroupRepository;
    private AlbumRepository albumRepository;


    @Autowired
    public MusicService(CompositionRepository compositionRepository, ExecutorRepository executorRepository, MusicGroupRepository musicGroupRepository, AlbumRepository albumRepository){
        this.compositionRepository=compositionRepository;
        this.executorRepository=executorRepository;
        this.musicGroupRepository=musicGroupRepository;
        this.albumRepository=albumRepository;
    }

    //Composition
    public void saveComp(CompositionDTO cdto){

        Album album = albumRepository.getAlbum(cdto.getCompositionAlbum());

        if (album!=null){

            Composition comp = new Composition();

            comp.setDuration(cdto.getDuration());
            comp.setName(cdto.getName());
            comp.setCompositionAlbum(album);

            compositionRepository.save(comp);
        }

    }

    @Override
    public CompositionDTO getComposition(Integer id) {

        if (compositionRepository.getComposition(id) !=null){
            Composition comp  = compositionRepository.getComposition(id);
            CompositionDTO cdto = new CompositionDTO();
            cdto.setId(comp.getId());
            cdto.setName(comp.getName());
            cdto.setDuration(comp.getDuration());
            cdto.setCompositionAlbum(comp.getCompositionAlbum().getId());

            return cdto;
        }

        return null;
    }

    //Executor
    public void saveExec(ExecutorDTO edto){
        System.out.println("LINE 39");
        Executor executor = new Executor();

        MusicGroup musicGroup=musicGroupRepository.getOne(edto.getMusicGroupId());
        System.out.println("LINE 44" + musicGroup.getName());

        if (musicGroup!=null){
            executor.setName(edto.getName());
            executor.setSurname(edto.getSurname());
            executor.setPatronymic(edto.getPatronymic());
            executor.setSex(edto.getSex());
            executor.setRole(edto.getRole());
            executor.setMusicGroup(musicGroup);

            System.out.println("LINE 52");

            executorRepository.save(executor);
        }
    }

    public  ExecutorDTO getExec(Integer id){
            Executor ex = executorRepository.getExec(id);

            if(ex!=null){
                ExecutorDTO exdto = new ExecutorDTO();
                exdto.setId(ex.getId());
                exdto.setName(ex.getName());
                exdto.setSurname(ex.getSurname());
                exdto.setPatronymic(ex.getPatronymic());
                exdto.setRole(ex.getRole());
                exdto.setSex(ex.getSex());
                exdto.setMusicGroupId(ex.getMusicGroup().getId());
                return exdto;
            }

        return  null;
    }

    // MusicGroup
    public MusicGroupDTO getMusic(Integer id){
//        return transferToDto( musicGroupRepository.getOne(id) );

        MusicGroup msG;

        msG = musicGroupRepository.getMusicGroup(id);

        if (msG!=null){
            return transferToDto(msG);
        }
        return null;
    }

    private MusicGroupDTO transferToDto(MusicGroup entity) {
        MusicGroupDTO dto = new MusicGroupDTO();
        dto.setId( entity.getId() );
        dto.setName( entity.getName() );
        dto.setCountry( entity.getCountry() );
        dto.setGenre( entity.getGenre() );
        if(entity.getExecutors() != null) {
            for(Executor executor : entity.getExecutors()) {
                dto.getExecutorIds().add( executor.getId() );
            }
        }
        if(entity.getAlbumList() != null) {
            for(Album albom : entity.getAlbumList()) {
                dto.getAlbumIds().add( albom.getId() );
            }
        }
        return dto;
    }

    public void saveMusicGroup(MusicGroupDTO mgdto){
        MusicGroup musicGroup = new MusicGroup();

        musicGroup.setName(mgdto.getName());
        musicGroup.setCountry(mgdto.getCountry());
        musicGroup.setGenre(mgdto.getGenre());
    }

    //Album
    public AlbumDTO getAlbum(Integer id){
        Album album =  albumRepository.getAlbum(id);

        if (album!=null){
            AlbumDTO adto = new AlbumDTO();
            adto.setId(album.getId());
            adto.setTitle(album.getTitle());
            adto.setReleazeDate(album.getReleaseDate());

            for(Composition comp : album.getCompositionList()){
                adto.getCompositionIds().add(comp.getId());
            }

            adto.setMusicGroupId(album.getAlbumMusicGroup().getId());
            return adto;
        }
        return null;
    }

    public void saveAlbum(AlbumDTO adto){
        MusicGroup mg = musicGroupRepository.getMusicGroup(adto.getMusicGroupId());

        if (mg!=null){
            Album album = new Album();
            album.setTitle(adto.getTitle());
            album.setReleaseDate(adto.getReleazeDate());
            album.setAlbumMusicGroup(mg);

            albumRepository.save(album);
        }
    }
}
