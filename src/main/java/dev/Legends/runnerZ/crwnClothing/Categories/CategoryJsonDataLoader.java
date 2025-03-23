package dev.Legends.runnerZ.crwnClothing.Categories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CategoryJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CategoryJsonDataLoader.class);
    private final JdbcCategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;
    //private final CategoryRepository categoryRepository;
    public CategoryJsonDataLoader(JdbcCategoryRepository categoryRepository, ObjectMapper objectMapper){
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count()==0 ){
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/Categories.json")){
                if (inputStream == null) {
                    throw new RuntimeException("File not found: /data/Categories.json");
                }
                Categories Categories = objectMapper.readValue(inputStream, Categories.class);
                log.info("Reading {} runs from JSON data and saving in-memory collection",Categories.categoryList().size());
                categoryRepository.saveAll(Categories.categoryList());

            }catch (IOException e){
                throw new RuntimeException("Failed to read JSON data",e);
            }
        }else{
            log.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }
}
