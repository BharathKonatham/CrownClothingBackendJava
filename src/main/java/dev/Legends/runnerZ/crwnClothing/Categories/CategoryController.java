package dev.Legends.runnerZ.crwnClothing.Categories;

import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/create")
public class CategoryController {

    public final JdbcCategoryRepository categoryRepository;

    CategoryController(JdbcCategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/get-all-categories")

    ResponseEntity<ApiResponse<List<Category>>> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        ApiResponse<List<Category>> response = new ApiResponse<>(categories,
                HttpStatus.OK.value(),"Categories Retrieved Successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
//    List<Category> findAll(){
//        return categoryRepository.findAll();
//    }

    @PostMapping("/category")
    ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody Category category){

        Category savedCategory = categoryRepository.create(category);

        ApiResponse<Category> response = new ApiResponse<>(savedCategory,
                HttpStatus.CREATED.value(),"Category Created Successfully");
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}


//example implementation of response
//@PutMapping("/createCategory")
//public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody Category category) {
//    try {
//        Category savedCategory = categoryRepository.save(category);
//
//        ApiResponse<Category> response = new ApiResponse<>("Category created successfully", savedCategory, HttpStatus.CREATED.value());
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//
//    } catch (Exception e) {
//        ApiResponse<Category> response = new ApiResponse<>("Error creating category", null, HttpStatus.INTERNAL_SERVER_ERROR.value());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }
//}
//public class ApiResponse<T> {
//    private String message;
//    private T data;
//    private int status;
//
//    // Constructor, getters, and setters
//}