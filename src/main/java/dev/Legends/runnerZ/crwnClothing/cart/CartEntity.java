package dev.Legends.runnerZ.crwnClothing.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class CartEntity {
    Integer userId;
    @Id
    @Column(nullable = false)
    Integer productId;
    @Column(length = 250)
    String title;
}
