package com.lucasfranco.foodmenu_fullstack.repositories;

import com.lucasfranco.foodmenu_fullstack.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    public List<Food> findAllByActiveTrue();

}
