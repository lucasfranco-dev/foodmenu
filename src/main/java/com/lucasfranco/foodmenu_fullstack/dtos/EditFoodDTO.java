package com.lucasfranco.foodmenu_fullstack.dtos;

public record EditFoodDTO(Long id, String name, String description, Double price, Boolean active){
}