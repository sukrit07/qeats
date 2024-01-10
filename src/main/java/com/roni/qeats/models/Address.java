package com.roni.qeats.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends BaseModel{

    private String street;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
