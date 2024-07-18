package com.lucasfranco.foodmenu_fullstack.services;

import com.lucasfranco.foodmenu_fullstack.dtos.CreateFoodDTO;
import com.lucasfranco.foodmenu_fullstack.dtos.EditFoodDTO;
import com.lucasfranco.foodmenu_fullstack.exceptions.IdAlreadyExistsException;
import com.lucasfranco.foodmenu_fullstack.exceptions.IncorretValuesException;
import com.lucasfranco.foodmenu_fullstack.exceptions.NoActiveResourceFoundException;
import com.lucasfranco.foodmenu_fullstack.models.Food;
import com.lucasfranco.foodmenu_fullstack.repositories.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> findAllActiveFoods(){
        List<Food> all = repository.findAllByActiveTrue();
        if (all.isEmpty()){
            throw new NoActiveResourceFoundException("Nenhum prato disponível no momento");
        }
        return all;
    }

    @Transactional
    public void createNewFood(CreateFoodDTO data){
        Food newFood = new Food(data);
        createVerifications(newFood);
        repository.save(newFood);
    }

    @Transactional
    public void editFood(EditFoodDTO data){
        Food oldFood = repository.getReferenceById(data.id());

        Food newFood = new Food();
        newFood.setId(oldFood.getId());
        newFood.setName(data.name());
        newFood.setDescription(data.description());
        newFood.setPrice(data.price());
        newFood.setActive(data.active());

        System.out.println(oldFood.getPrice() + newFood.getPrice());

        emptyAndNullVerifys(newFood);
        repository.save(newFood);
    }

    public void deleteFood(Long id){
        Food food = repository.getReferenceById(id);
        repository.delete(food);
    }


    private void createVerifications(Food obj){
        List<Food> allFoods = repository.findAll();

        emptyAndNullVerifys(obj);

        for (int i = 0; i < allFoods.size(); i++) {
            if (allFoods.get(i).getId().equals(obj.getId())){
                throw new IdAlreadyExistsException("Este ID já esta cadastrado");
            }
        }
    }

    private void emptyAndNullVerifys(Food obj){
        if (obj.getName() == null || obj.getName().isBlank() || obj.getPrice() == null || obj.getPrice() <= 0){
            throw new IncorretValuesException("Definição de valores incorreta");
        }
    }


}
