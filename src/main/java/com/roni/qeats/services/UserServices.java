package com.roni.qeats.services;

import com.roni.qeats.configs.AppConstants;
import com.roni.qeats.configs.ExceptionConst;
import com.roni.qeats.dtos.UserRequestDTO;
import com.roni.qeats.dtos.UserResponseDTO;
import com.roni.qeats.exceptions.InvalidDataException;
import com.roni.qeats.models.Roles;
import com.roni.qeats.models.Users;
import com.roni.qeats.repositories.RoleRepository;
import com.roni.qeats.repositories.UserRepository;
import com.roni.qeats.utils.validators.UserValidators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserValidators userValidators;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RoleRepository roleRepo;

  public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
    if(userValidators.checkEmptyFields(userRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(userValidators.validateMobileNumber(userRequestDTO.getMobileNo()) && userValidators.validateEmail(userRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    Users user = new Users();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.NORMAL_USER)).get();
    user.getRoles().add(role);
    user.setUsername(userRequestDTO.getName());
    user.setEmailId(userRequestDTO.getEmailId());
    user.setMobileNo(userRequestDTO.getMobileNo());
    user.setDateOfBirth(userRequestDTO.getDateOfBirth());
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    user.setUserType(userRequestDTO.getUserType());
    this.userRepository.save(user);
    return modelMapper.map(user, UserResponseDTO.class);
  }

  public UserResponseDTO createAdminRestuarantOwners(UserRequestDTO userRequestDTO) {
    if(userValidators.checkEmptyFields(userRequestDTO)){
      throw new InvalidDataException(ExceptionConst.EMPTY_FIELDS);
    }
    if(userValidators.validateMobileNumber(userRequestDTO.getMobileNo()) && userValidators.validateEmail(userRequestDTO.getEmailId())){
      throw new InvalidDataException(ExceptionConst.INVALID_FIELDS);
    }
    Users user = new Users();
    Roles role = this.roleRepo.findById(Long.valueOf(AppConstants.ADMIN_USER)).get();
    user.getRoles().add(role);
    user.setUsername(userRequestDTO.getName());
    user.setEmailId(userRequestDTO.getEmailId());
    user.setMobileNo(userRequestDTO.getMobileNo());
    user.setDateOfBirth(userRequestDTO.getDateOfBirth());
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    this.userRepository.save(user);
    return modelMapper.map(user, UserResponseDTO.class);
  }

  public UserResponseDTO getUserDetails(Long userId){
    Users user = this.userRepository.findById(userId).get();
    return modelMapper.map(user, UserResponseDTO.class);
  }

  public UserResponseDTO editUserDetails(Long userId, UserRequestDTO newDetailsUser){
    Users user = this.userRepository.findById(userId).get();
    user.setUsername(newDetailsUser.getName());
    user.setEmailId(newDetailsUser.getEmailId());
    user.setMobileNo(newDetailsUser.getMobileNo());
    user.setDateOfBirth(newDetailsUser.getDateOfBirth());
    this.userRepository.save(user);
    return modelMapper.map(user, UserResponseDTO.class);
  }

  public String deleteUser(Long userId){
    Users user = this.userRepository.findById(userId).get();
    this.userRepository.delete(user);
    return "Deleted successfully!";
  }
  
}
