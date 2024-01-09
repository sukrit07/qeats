package com.roni.qeats.utils.validators;

import com.roni.qeats.dtos.UserRequestDTO;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;


@Component
public class UserValidators {

  public Boolean validateEmail(String email){
    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    return Pattern.compile(regexPattern)
        .matcher(email)
        .matches();

  }

  public Boolean validateMobileNumber(String mobileNo){
    String regexPattern = "^\\d{10}$";
    return Pattern.compile(regexPattern)
        .matcher(mobileNo)
        .matches();
  }

  public boolean checkEmptyFields(UserRequestDTO userRequestDTO) {
    return (null == userRequestDTO.getName()
        && null == userRequestDTO.getEmailId()
        && null == userRequestDTO.getMobileNo()
        && null == userRequestDTO.getDateOfBirth());
  }
}
