package com.roni.qeats.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Users extends BaseModel {

  private String username;

  @Column(unique = true)
  private String mobileNo;
  private String emailId;
  private String password;
  private Date dateOfBirth;

  @Enumerated(EnumType.STRING)
  private UserType userType;

  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private Set<Roles> roles= new HashSet<>();

}
