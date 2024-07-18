package com.lucasfranco.foodmenu_fullstack.models;

import com.lucasfranco.foodmenu_fullstack.dtos.CreateFoodDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = Food.TABLE_NAME)
@Table(name = Food.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Food {
    public final static String TABLE_NAME = "foods";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "image")
    private String image;

    public Food(CreateFoodDTO data){
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.active = true;
        this.image = verifyNullableImage(data.image());
    }

    private String verifyNullableImage(String imageUrl){
        if (imageUrl == null){
            imageUrl = "https://www.biotecdermo.com.br/wp-content/uploads/2016/10/sem-imagem-10.jpg";
        }
        return imageUrl;
    }
}
