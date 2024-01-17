package com.roni.qeats.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class RestaurantEmployee extends BaseModel{

  private String username;

  @Column(unique = true)
  private String mobileNo;
  private String emailId;
  private String password;
  private Date dateOfBirth;

  @Enumerated(EnumType.STRING)
  private RestauarantEmployeeTypes restauarantEmployeeTypes;

  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private Set<Roles> roles= new HashSet<>();

  @OneToOne
  private Restaurant restaurant;

}
