package com.roni.qeats.dtos;

import com.roni.qeats.models.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;
import lombok.Data;

@Data
public class UserResponseDTO {

  private Long id;
  private String name;
  private String mobileNo;
  private String emailId;
  private String password;
  private Date dateOfBirth;

  @Enumerated(EnumType.STRING)
  private UserType userType;
}
