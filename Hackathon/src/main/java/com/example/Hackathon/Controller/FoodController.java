package com.example.Hackathon.Controller;

import com.example.Hackathon.Models.Food;
import com.example.Hackathon.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    private FoodService foodService;

    @GetMapping("/all")
    public Iterable<Food> findAll() {
        return foodService.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<?> createFood(@Valid @RequestBody Food food) {
        Food newFood = foodService.saveOrUpdateFood(food);
        return new ResponseEntity<Food>(newFood, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public Food getById(@PathVariable("id") Long id){
        return foodService.getById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFood(@PathVariable("id") Long id) {foodService.deleteFood(id);}

    @PutMapping(path = "{id}")
    public void updatingFood(@PathVariable("id") Long id,@RequestBody Food foodToUpdate) {
        foodService.updateFood(id,foodToUpdate);
    }
}
