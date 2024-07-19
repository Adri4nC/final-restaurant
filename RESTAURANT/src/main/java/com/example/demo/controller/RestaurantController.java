package com.example.demo.controller;

import com.example.demo.model.Restaurant;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register-restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/{idrestaurant}")
    public Restaurant getrestaurantById(@PathVariable Long idrestaurant) {
        return restaurantService.getrestaurantById(idrestaurant);
    }

    @PutMapping("/{idrestaurant}")
    public Restaurant updateRestaurant(@PathVariable Long idrestaurant, @RequestBody Restaurant restaurantDetails) {
        return restaurantService.updateRestaurant(idrestaurant, restaurantDetails);
    }

    @DeleteMapping("/{idrestaurant}")
    public void deleteRestaurant(@PathVariable Long idrestaurant) {
        restaurantService.deleteRestaurant(idrestaurant);
    }
}


