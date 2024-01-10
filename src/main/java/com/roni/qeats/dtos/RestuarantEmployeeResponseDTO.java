package com.roni.qeats.dtos;

import com.roni.qeats.models.RestauarantEmployeeTypes;
import com.roni.qeats.models.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;
import lombok.Data;

@Data
public class RestuarantEmployeeResponseDTO extends UserResponseDTO{

  @Enumerated(EnumType.STRING)
  private RestauarantEmployeeTypes restauarantEmployeeTypes;

}
