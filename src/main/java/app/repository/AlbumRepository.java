package app.repository;

import app.entity.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
    @Query("select a from Album  as a where a.id = :id")
    Album getAlbum(@Param("id") Integer id);
}
