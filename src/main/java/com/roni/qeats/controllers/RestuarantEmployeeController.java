package com.roni.qeats.controllers;

import com.roni.qeats.dtos.RestuarantEmployeeRequestDTO;
import com.roni.qeats.dtos.RestuarantEmployeeResponseDTO;
import com.roni.qeats.dtos.UserRequestDTO;
import com.roni.qeats.dtos.UserResponseDTO;
import com.roni.qeats.services.RestuarantEmployeeServices;
import com.roni.qeats.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/restuarantemployee")
public class RestuarantEmployeeController {

  @Autowired
  public RestuarantEmployeeServices restuarantEmployeeServices;

  @PostMapping("/create/admin")
  public ResponseEntity<RestuarantEmployeeResponseDTO> registerRestuarantOwner(@RequestBody RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO){
    return ResponseEntity.ok(this.restuarantEmployeeServices.createRestuarantOwners(restuarantEmployeeRequestDTO));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/create/staff")
  public ResponseEntity<RestuarantEmployeeResponseDTO> registerRestuarantEmployee(@RequestBody RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO){
    return ResponseEntity.ok(this.restuarantEmployeeServices.createRestuarantEmployees(restuarantEmployeeRequestDTO));
  }

  @GetMapping("/details/{id}")
  public ResponseEntity<RestuarantEmployeeResponseDTO> getRestuarantEmployeeDetails(@PathVariable Long id){
    return ResponseEntity.ok(this.restuarantEmployeeServices.getRestuarantEmployeeDetails(id));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/edit/{id}")
  public ResponseEntity<RestuarantEmployeeResponseDTO> editRestuarantEmployeeDetails(@PathVariable Long id,
      @RequestBody RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO){
    return ResponseEntity.ok(this.restuarantEmployeeServices.editRestuarantEmployeeDetails(id,
        restuarantEmployeeRequestDTO));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/details/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id){
    return ResponseEntity.ok(restuarantEmployeeServices.deleteRestuarantEmployee(id));
  }

}
