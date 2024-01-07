package com.roni.qeats.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Feedback extends BaseModel{

  private Double foodRating;
  private String foodComments;
  private Double agentRatings;
  private String agentComment;
}
