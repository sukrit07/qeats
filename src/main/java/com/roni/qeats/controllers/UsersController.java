package com.roni.qeats.controllers;

import com.roni.qeats.dtos.UserRequestDTO;
import com.roni.qeats.dtos.UserResponseDTO;
import com.roni.qeats.services.UserServices;
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
@RequestMapping("/user")
public class UsersController {

  @Autowired
  public UserServices userService;

  @PostMapping("/create")
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
    return ResponseEntity.ok(this.userService.createUser(userRequestDTO));
  }

  @GetMapping("/details/{id}")
  public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Long id){
    return ResponseEntity.ok(this.userService.getUserDetails(id));
  }
  @PutMapping("/edit/{id}")
  public ResponseEntity<UserResponseDTO> editUserDetails(@PathVariable Long id,
      @RequestBody UserRequestDTO userRequestDTO){
    return ResponseEntity.ok(this.userService.editUserDetails(id, userRequestDTO));
  }

  @DeleteMapping("/details/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id){
    return ResponseEntity.ok(userService.deleteUser(id));
  }
}
