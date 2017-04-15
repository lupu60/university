package com.gnp.ioth.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
  public List<Activity> findBySmartBand(SmartBand smartBand);

  public List<Activity> findBySmartBandAndTimestampAfterOrderByTimestampAsc(SmartBand smartBand, Timestamp timestamp);

}
 