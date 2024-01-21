package com.roni.qeats.controllers;


import com.roni.qeats.dtos.ItemsRequestDTO;
import com.roni.qeats.dtos.ItemsResponseDTO;
import com.roni.qeats.models.Items;
import com.roni.qeats.services.ItemsService;
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
@RequestMapping("/api/items")
public class ItemsController {

  @Autowired
  private ItemsService itemsService;

  @PostMapping("/add")
  public ResponseEntity<ItemsResponseDTO> addItems(@RequestBody ItemsRequestDTO itemRequestDTO){
    return ResponseEntity.ok(itemsService.addItems(itemRequestDTO));
  }

  @PutMapping("/update")
  public ResponseEntity<ItemsResponseDTO> updateItems(@RequestBody ItemsRequestDTO itemRequestDTO){
    return ResponseEntity.ok(itemsService.updateItems(itemRequestDTO));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<ItemsResponseDTO> getItems(@PathVariable Long id){
    return ResponseEntity.ok(itemsService.getItems(id));
  }


  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteItems(@PathVariable Long id){
    return ResponseEntity.ok(itemsService.deleteItems(id));
  }

}
