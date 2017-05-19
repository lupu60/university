package com.gnp.ioth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "smart_band")
public class SmartBand {

  @Id
  @Column(name = "mac", unique = true, nullable = false)
  private String mac;

  public SmartBand() {
    super();
  }

  public SmartBand(String mac) {
    super();
    this.mac = mac;
  }

}
