package app.repository;

import app.entity.Executor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExecutorRepository extends CrudRepository<Executor, Integer> {

    @Query("select e from Executor as e where e.id = :id")
    Executor getExec(@Param("id") Integer id);
}
