package com.roni.qeats.services;

import com.roni.qeats.dtos.UserRequestDTO;
import com.roni.qeats.dtos.UserResponseDTO;
import com.roni.qeats.models.Users;
import com.roni.qeats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

  @Autowired
  public UserRepository userRepository;

  public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
    Users user = new Users();
    user.setName(userRequestDTO.getName());
    user.setEmailId(userRequestDTO.getEmailId());
    user.setMobileNo(userRequestDTO.getMobileNo());
    user.setDateOfBirth(userRequestDTO.getDateOfBirth());
    this.userRepository.save(user);
    return mapUserToUserResponseDTO(user);
  }

  public UserResponseDTO getUserDetails(Long userId){
    Users user = this.userRepository.findById(userId).get();
    return mapUserToUserResponseDTO(user);
  }

  public UserResponseDTO editUserDetails(Long userId, UserRequestDTO newDetailsUser){
    Users user = this.userRepository.findById(userId).get();
    user.setName(newDetailsUser.getName());
    user.setEmailId(newDetailsUser.getEmailId());
    user.setMobileNo(newDetailsUser.getMobileNo());
    user.setDateOfBirth(newDetailsUser.getDateOfBirth());
    this.userRepository.save(user);
    return mapUserToUserResponseDTO(user);
  }

  public String deleteUser(Long userId){
    Users user = this.userRepository.findById(userId).get();
    this.userRepository.delete(user);
    return "Deleted successfully!";
  }


  private UserResponseDTO mapUserToUserResponseDTO(Users user){
    UserResponseDTO userResponseDTO = new UserResponseDTO();
    userResponseDTO.setId(user.getId());
    userResponseDTO.setName(user.getName());
    userResponseDTO.setEmailId(user.getEmailId());
    userResponseDTO.setMobileNo(user.getMobileNo());
    userResponseDTO.setDateOfBirth(user.getDateOfBirth());
    return userResponseDTO;
  }
}
