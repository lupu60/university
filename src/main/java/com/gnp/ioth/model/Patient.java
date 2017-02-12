package com.gnp.ioth.model;

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

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "sex")
  private Sex sex;

  @Column(name = "band", unique = true)
  private UUID bandId;



  public Patient() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Patient(String name, Sex sex, UUID bandId) {
    super();
    this.name = name;
    this.sex = sex;
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

  public UUID getBandId() {
    return bandId;
  }

  public void setBandId(UUID bandId) {
    this.bandId = bandId;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bandId == null) ? 0 : bandId.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Patient other = (Patient) obj;
    if (bandId == null) {
      if (other.bandId != null)
        return false;
    } else if (!bandId.equals(other.bandId))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (sex != other.sex)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Patient [id=" + id + ", name=" + name + ", sex=" + sex + ", bandId=" + bandId + "]";
  }

}
