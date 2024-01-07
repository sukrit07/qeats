package com.roni.qeats.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agents extends BaseModel{
  private String name;

  @Column(unique = true)
  private String mobileNo;
  private String mailId;
  private String password;
}
