package dev.Legends.runnerZ.crwnClothing.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(length = 250, nullable = false)
    String title;
    @Column(length = 500)
    String image_url;
    @Column(nullable = false)
    double price;
    @Column(length = 100)
    String category;
}
