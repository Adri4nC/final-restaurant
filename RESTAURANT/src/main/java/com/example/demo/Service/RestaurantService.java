package com.example.demo.Service;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant createRestaurant (Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getrestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));

        restaurant.setNameRestaurant(restaurantDetails.getNameRestaurant());
        restaurant.setDepartament(restaurantDetails.getDepartament());
        restaurant.setProvince(restaurantDetails.getProvince());
        restaurant.setDistrict(restaurantDetails.getDistrict());
        restaurant.setAddress(restaurantDetails.getAddress());
        restaurant.setKindofood(restaurantDetails.getKindofood());
        restaurant.setPhonenumber(restaurantDetails.getPhonenumber());
        restaurant.setPricerange(restaurantDetails.getPricerange());
        restaurant.setDescription(restaurantDetails.getDescription());

        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
