package dev.Legends.runnerZ.crwnClothing.Categories;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public final CategoryRepository categoryRepository;
    public final ModelMapper modelMapper;
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    }

    public CategoryDTO createCategory(CategoryDTO newCategory) {
        CategoryEntity category = modelMapper.map(newCategory, CategoryEntity.class);
        CategoryEntity savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}
