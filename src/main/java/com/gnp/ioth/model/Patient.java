package com.gnp.ioth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
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


}
