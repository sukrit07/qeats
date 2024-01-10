package com.roni.qeats.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class OrderItems extends BaseModel{

  @OneToOne
  private Orders orderNumber;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Items> orderedItems;
}
