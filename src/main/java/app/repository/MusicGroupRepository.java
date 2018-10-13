package app.repository;

import app.entity.MusicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MusicGroupRepository extends JpaRepository<MusicGroup, Integer> {

    @Query("select g from MusicGroup as g where g.id = :id")
    MusicGroup getMusicGroup(@Param("id") Integer id);

}
