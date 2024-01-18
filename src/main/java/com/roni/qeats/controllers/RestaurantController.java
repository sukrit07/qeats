package com.roni.qeats.controllers;

import com.roni.qeats.dtos.RestaurantRequestDTO;
import com.roni.qeats.dtos.RestaurantResponseDTO;
import com.roni.qeats.models.BaseModel;
import com.roni.qeats.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController{

  @Autowired
  private RestaurantService restaurantService;

  @PostMapping("/add")
  public ResponseEntity<RestaurantResponseDTO> addRestaurant(@RequestBody RestaurantRequestDTO restaurantRequestDTO){
    return ResponseEntity.ok(restaurantService.addRestaurant(restaurantRequestDTO));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<RestaurantResponseDTO> getRestaurantDetails(@PathVariable Long id){
    return ResponseEntity.ok(restaurantService.getRestaurantDetails(id));
  }

  @PutMapping("/edit/{id}")
  public ResponseEntity<RestaurantResponseDTO> editRestaurantDetails(@PathVariable Long id,
      @RequestBody RestaurantRequestDTO restaurantRequestDTO){
    return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurantRequestDTO));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteRestaurantDetails(@PathVariable Long id,
      @RequestBody RestaurantRequestDTO restaurantRequestDTO){
    return ResponseEntity.ok("Restaurant is no longer in our system");
  }

}
