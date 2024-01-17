package com.roni.qeats.dtos;


import com.roni.qeats.models.Address;
import lombok.Data;

@Data
public class RestaurantRequestDTO {

  private String restaurantName;
  private Address address;
  private String emailId;
  private String mobileNumber;
  private String gstIn;


}
