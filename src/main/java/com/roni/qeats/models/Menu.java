package com.roni.qeats.models;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Menu extends BaseModel{

  private List<Items> items;
  private Restuarant restuarant;

}
