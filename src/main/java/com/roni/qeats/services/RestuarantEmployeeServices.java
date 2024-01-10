package com.roni.qeats.services;


import com.roni.qeats.configs.AppConstants;
import com.roni.qeats.configs.ExceptionConst;
import com.roni.qeats.dtos.RestuarantEmployeeRequestDTO;
import com.roni.qeats.dtos.RestuarantEmployeeResponseDTO;
import com.roni.qeats.dtos.UserRequestDTO;

import com.roni.qeats.exceptions.InvalidDataException;
import com.roni.qeats.models.RestuarantEmployee;
import com.roni.qeats.models.Roles;
import com.roni.qeats.repositories.RestuarantEmployeeRepository;
import com.roni.qeats.repositories.RoleRepository;
import com.roni.qeats.utils.validators.UserValidators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestuarantEmployeeServices {

  @Autowired
  private RestuarantEmployeeRepository restuarantEmployeeRepository;

  @Autowired
  private UserValidators userValidators;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RoleRepository roleRepo;

  public RestuarantEmployeeResponseDTO createRestuarantEmployees(RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO) {
    if(userValidators.checkEmptyFields(restuarantEmployeeRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(userValidators.validateMobileNumber(restuarantEmployeeRequestDTO.getMobileNo()) && userValidators.validateEmail(restuarantEmployeeRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    RestuarantEmployee restuarantEmployee = new RestuarantEmployee();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.NORMAL_USER)).get();
    restuarantEmployee.getRoles().add(role);
    restuarantEmployee.setUsername(restuarantEmployeeRequestDTO.getName());
    restuarantEmployee.setEmailId(restuarantEmployeeRequestDTO.getEmailId());
    restuarantEmployee.setMobileNo(restuarantEmployeeRequestDTO.getMobileNo());
    restuarantEmployee.setDateOfBirth(restuarantEmployeeRequestDTO.getDateOfBirth());
    restuarantEmployee.setPassword(this.passwordEncoder.encode(restuarantEmployee.getPassword()));
    restuarantEmployee.setRestauarantEmployeeTypes(restuarantEmployeeRequestDTO.getRestauarantEmployeeTypes());
    restuarantEmployee.setUserType(restuarantEmployeeRequestDTO.getUserType());
    return modelMapper.map(restuarantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO createRestuarantOwners(RestuarantEmployeeRequestDTO restuarantEmployeeRequestDTO) {
    if(userValidators.checkEmptyFields(restuarantEmployeeRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(userValidators.validateMobileNumber(restuarantEmployeeRequestDTO.getMobileNo()) && userValidators.validateEmail(restuarantEmployeeRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    RestuarantEmployee restuarantEmployee = new RestuarantEmployee();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.ADMIN_USER)).get();
    restuarantEmployee.getRoles().add(role);
    restuarantEmployee.setUsername(restuarantEmployeeRequestDTO.getName());
    restuarantEmployee.setEmailId(restuarantEmployeeRequestDTO.getEmailId());
    restuarantEmployee.setMobileNo(restuarantEmployeeRequestDTO.getMobileNo());
    restuarantEmployee.setDateOfBirth(restuarantEmployeeRequestDTO.getDateOfBirth());
    restuarantEmployee.setPassword(this.passwordEncoder.encode(restuarantEmployee.getPassword()));
    restuarantEmployee.setRestauarantEmployeeTypes(restuarantEmployeeRequestDTO.getRestauarantEmployeeTypes());
    restuarantEmployee.setUserType(restuarantEmployeeRequestDTO.getUserType());
    return modelMapper.map(restuarantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO getRestuarantEmployeeDetails(Long userId){
    RestuarantEmployee restuarantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    return modelMapper.map(restuarantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public RestuarantEmployeeResponseDTO editRestuarantEmployeeDetails(Long userId, UserRequestDTO newDetailsUser){
    RestuarantEmployee restuarantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    restuarantEmployee.setUsername(newDetailsUser.getName());
    restuarantEmployee.setEmailId(newDetailsUser.getEmailId());
    restuarantEmployee.setMobileNo(newDetailsUser.getMobileNo());
    restuarantEmployee.setDateOfBirth(newDetailsUser.getDateOfBirth());
    this.restuarantEmployeeRepository.save(restuarantEmployee);
    return modelMapper.map(restuarantEmployee, RestuarantEmployeeResponseDTO.class);
  }

  public String deleteRestuarantEmployee(Long userId){
    RestuarantEmployee restuarantEmployee = this.restuarantEmployeeRepository.findById(userId).get();
    this.restuarantEmployeeRepository.delete(restuarantEmployee);
    return "Deleted successfully!";
  }

}
