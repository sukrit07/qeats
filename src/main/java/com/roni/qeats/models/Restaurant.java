package com.roni.qeats.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Restaurant extends BaseModel{

  private String restaurantName;

  @OneToOne(cascade = CascadeType.PERSIST)
  private Address address;

  @Column(unique = true)
  private String emailId;

  @Column(unique = true)
  private String mobileNumber;

  @Column(unique = true)
  private String gstIn;

  @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
  private List<Menu> menuList;


}
