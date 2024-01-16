package com.roni.qeats.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Menu extends BaseModel{

  @OneToMany(mappedBy = "menu", cascade = CascadeType.REMOVE)
  private List<Items> items;

  @ManyToOne
  private Restaurant restaurant;

}
