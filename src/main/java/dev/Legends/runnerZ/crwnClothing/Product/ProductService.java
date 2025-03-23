package dev.Legends.runnerZ.crwnClothing.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ProductService {

    public final ProductRepository productRepository;
    public final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository,ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO createProduct(ProductDTO newProduct) {
        Product product = modelMapper.map(newProduct,Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDTO.class);
    }
}
