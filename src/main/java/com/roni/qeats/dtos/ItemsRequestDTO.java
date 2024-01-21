package com.roni.qeats.dtos;


import com.roni.qeats.models.ItemAttributes;
import com.roni.qeats.models.Menu;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Data;

@Data
public class ItemsRequestDTO {

  private String delicacyName;

  @ElementCollection
  @Enumerated(value = EnumType.STRING)
  private List<ItemAttributes> attributes;
  private Double price;
  @ManyToOne
  private Menu menu;
}
