package dev.Legends.runnerZ.crwnClothing.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductDTO {
    Integer id;
    String title;
    @JsonProperty ("imageUrl")
    String image_url;

    double price;

    String category;
}
