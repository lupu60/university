package com.gnp.ioth.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "activity")
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "steps", unique = false, nullable = false)
  private int steps;

  @Column(name = "heartRate", unique = false, nullable = false)
  private ArrayList<Integer> heartRate;

  @ManyToOne
  private SmartBand smartBand;

  @Column(name = "timestamp", unique = false, nullable = false)
  private Timestamp timestamp;

  public Activity() {
    super();
  }


  public Activity(Long id, int steps, ArrayList<Integer> heartRate, SmartBand smartBand,
      Timestamp timestamp) {
    super();
    this.id = id;
    this.steps = steps;
    this.heartRate = heartRate;
    this.smartBand = smartBand;
    this.timestamp = timestamp;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public int getSteps() {
    return steps;
  }


  public void setSteps(int steps) {
    this.steps = steps;
  }


  public ArrayList<Integer> getHeartRate() {
    return heartRate;
  }


  public void setHeartRate(ArrayList<Integer> heartRate) {
    this.heartRate = heartRate;
  }


  public SmartBand getSmartBand() {
    return smartBand;
  }


  public void setSmartBand(SmartBand smartBand) {
    this.smartBand = smartBand;
  }


  public Timestamp getTimestamp() {
    return timestamp;
  }


  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

}