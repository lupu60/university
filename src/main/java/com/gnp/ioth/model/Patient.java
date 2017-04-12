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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "sex")
  private boolean sex;

  @Column(name = "age")
  private int age;

  @Column(name = "height")
  private int height;

  @Column(name = "weight")
  private int weight;

  @OneToOne
  private SmartBand smartBand;

  public Patient() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Patient(Long id, String name, boolean sex, int age, int height, int weight,
      SmartBand smartBand) {
    super();
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.smartBand = smartBand;
  }

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

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public SmartBand getSmartBand() {
    return smartBand;
  }

  public void setSmartBand(SmartBand smartBand) {
    this.smartBand = smartBand;
  }

}
