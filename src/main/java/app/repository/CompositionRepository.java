package app.repository;

import app.entity.Composition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompositionRepository extends CrudRepository<Composition, Integer> {

    @Query("select c from Composition as c where c.id = :id")
    Composition getComposition(@Param("id") Integer id);
}
