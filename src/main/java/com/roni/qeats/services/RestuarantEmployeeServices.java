package com.roni.qeats.services;


import com.roni.qeats.configs.AppConstants;
import com.roni.qeats.configs.ExceptionConst;
import com.roni.qeats.dtos.RestuarantEmployeeRequestDTO;
import com.roni.qeats.dtos.RestuarantEmployeeResponseDTO;
import com.roni.qeats.dtos.UserRequestDTO;

import com.roni.qeats.exceptions.InvalidDataException;
import com.roni.qeats.models.RestaurantEmployee;
import com.roni.qeats.models.Roles;
import com.roni.qeats.repositories.RestuarantEmployeeRepository;
import com.roni.qeats.repositories.RoleRepository;
import com.roni.qeats.utils.validators.DataInputValidators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestuarantEmployeeServices {

  @Autowired
  private RestuarantEmployeeRepository restuarantEmployeeRepository;

  @Autowired
  private DataInputValidators DataInputValidators;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RoleRepository roleRepo;

  public RestuarantEmployeeResponseDTO createRestuarantEmployees(RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO) {
    if(DataInputValidators.checkEmptyFields(restuarantEmployeeRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(DataInputValidators.validateMobileNumber(restuarantEmployeeRequestDTO.getMobileNo()) && DataInputValidators.validateEmail(restuarantEmployeeRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    RestaurantEmployee restaurantEmployee = new RestaurantEmployee();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.NORMAL_USER)).get();
    restaurantEmployee.getRoles().add(role);
    restaurantEmployee.setUsername(restuarantEmployeeRequestDTO.getName());
    restaurantEmployee.setEmailId(restuarantEmployeeRequestDTO.getEmailId());
    restaurantEmployee.setMobileNo(restuarantEmployeeRequestDTO.getMobileNo());
    restaurantEmployee.setDateOfBirth(restuarantEmployeeRequestDTO.getDateOfBirth());
    restaurantEmployee.setPassword(this.passwordEncoder.encode(restaurantEmployee.getPassword()));
    restaurantEmployee.setRestauarantEmployeeTypes(restuarantEmployeeRequestDTO.getRestauarantEmployeeTypes());
    //restuarantEmployee.setUserType(restuarantEmployeeRequestDTO.getUserType());
    return modelMapper.map(restaurantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO createRestuarantOwners(RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO) {
    if(DataInputValidators.checkEmptyFields(restuarantEmployeeRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(DataInputValidators.validateMobileNumber(restuarantEmployeeRequestDTO.getMobileNo()) && DataInputValidators.validateEmail(restuarantEmployeeRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    RestaurantEmployee restaurantEmployee = new RestaurantEmployee();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.ADMIN_USER)).get();
    restaurantEmployee.getRoles().add(role);
    restaurantEmployee.setUsername(restuarantEmployeeRequestDTO.getName());
    restaurantEmployee.setEmailId(restuarantEmployeeRequestDTO.getEmailId());
    restaurantEmployee.setMobileNo(restuarantEmployeeRequestDTO.getMobileNo());
    restaurantEmployee.setDateOfBirth(restuarantEmployeeRequestDTO.getDateOfBirth());
    restaurantEmployee.setPassword(this.passwordEncoder.encode(restaurantEmployee.getPassword()));
    restaurantEmployee.setRestauarantEmployeeTypes(restuarantEmployeeRequestDTO.getRestauarantEmployeeTypes());
    //restuarantEmployee.setUserType(restuarantEmployeeRequestDTO.getUserType());
    return modelMapper.map(restaurantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO getRestuarantEmployeeDetails(Long userId){
    RestaurantEmployee restaurantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    return modelMapper.map(restaurantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO editRestuarantEmployeeDetails(Long userId, UserRequestDTO newDetailsUser){
    RestaurantEmployee restaurantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    restaurantEmployee.setUsername(newDetailsUser.getName());
    restaurantEmployee.setEmailId(newDetailsUser.getEmailId());
    restaurantEmployee.setMobileNo(newDetailsUser.getMobileNo());
    restaurantEmployee.setDateOfBirth(newDetailsUser.getDateOfBirth());
    this.restuarantEmployeeRepository.save(restaurantEmployee);
    return modelMapper.map(restaurantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public String deleteRestuarantEmployee(Long userId){
    RestaurantEmployee restaurantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    this.restuarantEmployeeRepository.delete(restaurantEmployee);
    return "Deleted successfully!";
  }

}
