package com.roni.qeats.dtos;

import com.roni.qeats.models.RestauarantEmployeeTypes;
import com.roni.qeats.models.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;
import lombok.Data;
import lombok.Setter;


@Setter
@Data
public class RestuarantEmployeeRequestDTO  extends UserRequestDTO{

  @Enumerated(EnumType.STRING)
  private RestauarantEmployeeTypes restauarantEmployeeTypes;

}
