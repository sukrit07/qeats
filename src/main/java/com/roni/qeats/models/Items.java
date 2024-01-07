package com.roni.qeats.models;


import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Items extends BaseModel{

  private String delicacyName;
  private List<ItemAttributes> attributes;
  private Double price;

}
