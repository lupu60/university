package com.gnp.ioth.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "sex")
  private Sex sex;

  @Column(name = "dateOfBirth")
  private Date dateOfBirth;

  @Column(name = "band")
  private UUID bandId;



  public Patient() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Patient(Long id, String name, Sex sex, Date dateOfBirth, UUID bandId) {
    super();
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.dateOfBirth = dateOfBirth;
    this.bandId = bandId;
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

  public UUID getBandId() {
    return bandId;
  }

  public void setBandId(UUID bandId) {
    this.bandId = bandId;
  }



}
