package com.roni.qeats.services;

import com.roni.qeats.configs.ExceptionConst;
import com.roni.qeats.dtos.RestaurantRequestDTO;
import com.roni.qeats.dtos.RestaurantResponseDTO;
import com.roni.qeats.exceptions.InvalidDataException;
import com.roni.qeats.models.Address;
import com.roni.qeats.models.Restaurant;
import com.roni.qeats.repositories.AddressRepository;
import com.roni.qeats.repositories.RestaurantRepository;
import com.roni.qeats.utils.validators.DataInputValidators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private DataInputValidators validators;

  @Autowired
  private AddressRepository addressRepo;

  @Autowired
  private ModelMapper modelMapper;

  public RestaurantResponseDTO addRestaurant(RestaurantRequestDTO requestDTO){
    if(validators.checkEmptyFieldsRestaurants(requestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(validators.validateMobileNumber(requestDTO.getMobileNumber()) && validators.validateEmail(requestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }

    Restaurant restaurant = modelMapper.map(requestDTO, Restaurant.class);
    restaurant = restaurantRepository.save(restaurant);
    return modelMapper.map(restaurant, RestaurantResponseDTO.class);
  }

  public RestaurantResponseDTO updateRestaurant(Long id, RestaurantRequestDTO requestDTO){
    if(validators.checkEmptyFieldsRestaurants(requestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(validators.validateMobileNumber(requestDTO.getMobileNumber()) && validators.validateEmail(requestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }

    Restaurant restaurant = restaurantRepository.findById(id).get();

    restaurant.setRestaurantName(requestDTO.getRestaurantName());
    restaurant.setGstIn(requestDTO.getGstIn());
    restaurant.setMobileNumber(requestDTO.getMobileNumber());
    restaurant.setEmailId(requestDTO.getEmailId());

    Address address = this.addressRepo.findById(requestDTO.getAddress().getId()).get();
    address.setStreet(requestDTO.getAddress().getStreet());
    address.setPinCode(requestDTO.getAddress().getPinCode());
    address.setCity(requestDTO.getAddress().getCity());
    address.setCountry(requestDTO.getAddress().getCountry());
    restaurant.setAddress(this.addressRepo.save(address));

    restaurant = restaurantRepository.save(restaurant);
    return modelMapper.map(restaurant, RestaurantResponseDTO.class);
  }

  public RestaurantResponseDTO getRestaurantDetails(Long id){
    Restaurant restaurant = restaurantRepository.findById(id).get();
    return modelMapper.map(restaurant, RestaurantResponseDTO.class);
  }

  public void deleteRestaurant(RestaurantRequestDTO requestDTO){
    restaurantRepository.delete(modelMapper.map(requestDTO, Restaurant.class));
  }

}
