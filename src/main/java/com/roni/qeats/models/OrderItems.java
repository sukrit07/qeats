package com.roni.qeats.models;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class OrderItems extends BaseModel{
  private Orders orderNumber;
  private List<Items> orderedItems;
}
