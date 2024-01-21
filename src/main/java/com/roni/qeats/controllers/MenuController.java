package com.roni.qeats.controllers;

import com.roni.qeats.dtos.MenuRequestDTO;
import com.roni.qeats.dtos.MenuResponseDTO;
import com.roni.qeats.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;


  @PostMapping("/add")
  public ResponseEntity<MenuResponseDTO> addMenu(@RequestBody MenuRequestDTO menuRequestDTO){
      return ResponseEntity.ok(menuService.addMenu(menuRequestDTO));
  }


  @GetMapping("/get/{id}")
  public ResponseEntity<MenuResponseDTO> getMenu(@PathVariable Long id){
    return ResponseEntity.ok(menuService.getMenu(id));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteMenu(@PathVariable Long id){
    return ResponseEntity.ok(menuService.deleteMenu(id));
  }

}
