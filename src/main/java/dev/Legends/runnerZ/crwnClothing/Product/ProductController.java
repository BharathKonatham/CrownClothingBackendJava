package dev.Legends.runnerZ.crwnClothing.Product;


import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/create")
public class ProductController {
    private final ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@RequestBody ProductDTO product){
        try{
            ProductDTO createdProduct = productService.createProduct(product);

            ApiResponse<ProductDTO> response = new ApiResponse<>(createdProduct,HttpStatus.CREATED.value(),
                    "ProductEntity Created Successfully");
            System.out.println(response.toString());
            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            ApiResponse<ProductDTO> response = new ApiResponse<>(null,HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failed to create product");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @GetMapping("/getallproducts")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts(){
        try{
            List<ProductDTO> productDTOList = productService.getAllProducts();
            if(productDTOList.isEmpty()){
                ApiResponse<List<ProductDTO>> response = new ApiResponse<>(productDTOList,HttpStatus.OK.value(), "No products Available");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            ApiResponse<List<ProductDTO>> response = new ApiResponse<>(productDTOList,HttpStatus.OK.value(), "Products received successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (Exception e){
            ApiResponse<List<ProductDTO>> response = new ApiResponse<>(new ArrayList<ProductDTO>(),HttpStatus.INTERNAL_SERVER_ERROR.value(), "An internal error occurred while processing your request. Please try again later");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
