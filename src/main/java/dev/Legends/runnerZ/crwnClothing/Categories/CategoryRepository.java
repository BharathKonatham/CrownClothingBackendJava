package dev.Legends.runnerZ.crwnClothing.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

}
