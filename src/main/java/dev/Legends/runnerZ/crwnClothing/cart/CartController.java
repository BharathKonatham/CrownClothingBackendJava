package dev.Legends.runnerZ.crwnClothing.cart;

import dev.Legends.runnerZ.crwnClothing.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    CartService cartService;
    CartController(CartService cartService){
        this.cartService = cartService;
    }
//    @GetMapping("/addtocart")
//    public ResponseEntity<ApiResponse<CartDTO>>addItemToCart(@RequestBody CartDTO cartDTO){
//
//        cartService.addItemToCart(cartDTO);
//        return ResponseEntity.status(HttpStatus.OK);
//    }



}
