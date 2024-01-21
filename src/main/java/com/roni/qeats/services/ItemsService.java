package com.roni.qeats.services;


import com.roni.qeats.dtos.ItemsRequestDTO;
import com.roni.qeats.dtos.ItemsResponseDTO;
import com.roni.qeats.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

  @Autowired
  private ItemsRepository itemsRepository;

  public ItemsResponseDTO addItems(ItemsRequestDTO itemsRequestDTO){
    return null;
  }

  public ItemsResponseDTO updateItems(ItemsRequestDTO itemsRequestDTO){
    return null;
  }

  public ItemsResponseDTO getItems(Long id){
    return null;
  }

  public String deleteItems(Long id){
    return null;
  }

}
