package dev.Legends.runnerZ.crwnClothing.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductService {

    public final ProductRepository productRepository;
    public final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository,ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    }

    public ProductDTO createProduct(ProductDTO newProduct) {
        ProductEntity product = modelMapper.map(newProduct, ProductEntity.class);
        ProductEntity savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();
        return modelMapper.map(allProducts,new TypeToken<List<ProductDTO>>(){}.getType());
    }
}
