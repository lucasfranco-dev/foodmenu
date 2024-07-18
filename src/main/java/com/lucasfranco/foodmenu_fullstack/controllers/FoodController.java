package com.lucasfranco.foodmenu_fullstack.controllers;

import com.lucasfranco.foodmenu_fullstack.dtos.CreateFoodDTO;
import com.lucasfranco.foodmenu_fullstack.dtos.EditFoodDTO;
import com.lucasfranco.foodmenu_fullstack.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping
    public ResponseEntity getAllFoods(){
        return ResponseEntity.status(HttpStatus.OK).body(foodService.findAllActiveFoods());
    }

    @PostMapping
    public ResponseEntity createNewFood(@RequestBody CreateFoodDTO data){
        foodService.createNewFood(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity editFood(@RequestBody EditFoodDTO data){
        foodService.editFood(data);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
