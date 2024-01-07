package com.roni.qeats.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Users extends BaseModel{

  private String name;

  @Column(unique = true)
  private String mobileNo;
  private String emailId;
  private String password;
  private Date dateOfBirth;

  @Enumerated(EnumType.STRING)
  private UserType userType;

}
