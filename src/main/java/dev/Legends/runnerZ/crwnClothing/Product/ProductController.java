package dev.Legends.runnerZ.crwnClothing.Product;


import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class ProductController {
    private final ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(ProductDTO product){
        try{
            ProductDTO createdProduct = productService.createProduct(product);
            ApiResponse<ProductDTO> response = new ApiResponse<>(createdProduct,HttpStatus.CREATED.value(),
                    "Product Created Successfully");
            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            ApiResponse<ProductDTO> response = new ApiResponse<>(null,HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failed to create product");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
