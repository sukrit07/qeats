package com.roni.qeats.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Items extends BaseModel{

  private String delicacyName;

  @Enumerated(value = EnumType.STRING)
  private List<ItemAttributes> attributes;
  private Double price;
  @ManyToOne
  private Menu menu;

}
