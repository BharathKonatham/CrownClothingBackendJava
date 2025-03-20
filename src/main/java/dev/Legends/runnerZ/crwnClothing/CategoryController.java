package dev.Legends.runnerZ.crwnClothing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    public final JdbcCategoryRepository categoryRepository;

    CategoryController(JdbcCategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
