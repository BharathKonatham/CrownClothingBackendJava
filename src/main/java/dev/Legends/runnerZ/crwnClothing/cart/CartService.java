package dev.Legends.runnerZ.crwnClothing.cart;

import org.springframework.stereotype.Component;

@Component
public class CartService {

    public final CartRepository cartRepository;

    CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void addItemToCart(CartDTO cartDTO) {

    }
}
