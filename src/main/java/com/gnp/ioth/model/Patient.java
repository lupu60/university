package com.gnp.ioth.model;

import java.sql.Date;
import java.util.UUID;


public class Patient {
  public enum Sex {
    FEMALE, MALE
  }

  private UUID id;
  private String name;
  private Sex sex;
  private Date dateOfBirth;

  public Patient(UUID id, String name, Sex sex, Date dateOfBirth) {
    super();
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.dateOfBirth = dateOfBirth;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

}
