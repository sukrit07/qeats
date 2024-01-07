package com.roni.qeats.models;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Orders extends BaseModel{

  private OrderItems orderItems;
  private Double amount;
  private Users user;
  private Agents deliveryAgent;
  private Address delveryAddress;
  private OrderStatus orderStatus;
  private PaymentMethod paymentMethod;
  private PaymentStatus paymentStatus;
  private Feedback feedback;

}
