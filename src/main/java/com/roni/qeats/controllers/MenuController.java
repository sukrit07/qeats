package com.roni.qeats.controllers;

import com.roni.qeats.dtos.MenuRequestDTO;
import com.roni.qeats.dtos.MenuResponseDTO;
import com.roni.qeats.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;


  @PostMapping("/add")
  public MenuResponseDTO addMenu(@RequestBody MenuRequestDTO menuRequestDTO){
      return menuService.addMenu(menuRequestDTO);
  }

  @PutMapping("/edit")
  public MenuResponseDTO editMenu(@RequestBody MenuRequestDTO menuRequestDTO){
    return menuService.updateMenu(menuRequestDTO);
  }

  @GetMapping("/get/{id}")
  public MenuResponseDTO getMenu(@PathVariable Long id){
    return menuService.getMenu(id);
  }

  @DeleteMapping("/delete/{id}")
  public MenuResponseDTO deleteMenu(@PathVariable Long id){
    return menuService.deleteMenu(id);
  }

}
