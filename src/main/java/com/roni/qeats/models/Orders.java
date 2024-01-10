package com.roni.qeats.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Orders extends BaseModel{

  @OneToOne
  private OrderItems orderItems;
  private Double amount;

  @ManyToOne
  private Users user;

  @OneToOne
  private Agents deliveryAgent;

  @OneToOne
  private Address deliveryAddress;

  private OrderStatus orderStatus;
  private PaymentMethod paymentMethod;
  private PaymentStatus paymentStatus;

  @OneToOne
  private Feedback feedback;

}
