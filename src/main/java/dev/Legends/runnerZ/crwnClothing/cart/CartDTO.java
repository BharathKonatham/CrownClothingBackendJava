package dev.Legends.runnerZ.crwnClothing.cart;

import dev.Legends.runnerZ.crwnClothing.Product.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.Date;


public class CartDTO {
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private Date added_at;
    private ProductDTO product;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getAdded_at() {
        return added_at;
    }

    public void setAdded_at(Date added_at) {
        this.added_at = added_at;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
