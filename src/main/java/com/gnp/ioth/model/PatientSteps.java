package com.gnp.ioth.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_steps")
public class PatientSteps {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "patientId", nullable = false)
  private Patient patient;
  
  @Column(name = "steps", nullable = false)
  private int steps;

  @Column(name = "timestamp", nullable = false)
  private Timestamp timestamp;
}
