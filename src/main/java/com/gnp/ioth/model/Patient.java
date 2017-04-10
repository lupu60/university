package com.gnp.ioth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
  public enum Sex {
    FEMALE, MALE
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "sex")
  private Sex sex;

  @OneToOne
  private SmartBand smartBand;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public SmartBand getSmartBand() {
    return smartBand;
  }

  public void setSmartBand(SmartBand smartBand) {
    this.smartBand = smartBand;
  }

  @Override
  public String toString() {
    return "Patient [id=" + id + ", name=" + name + ", sex=" + sex + ", smartBand=" + smartBand
        + "]";
  }

}
