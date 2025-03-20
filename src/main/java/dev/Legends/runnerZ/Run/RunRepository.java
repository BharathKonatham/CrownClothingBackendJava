package dev.Legends.runnerZ.Run;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run,Integer> {

    List<Run> findAllByLocation(String location);
}
