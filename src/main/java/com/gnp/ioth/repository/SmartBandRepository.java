package com.gnp.ioth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;

@Repository
public interface SmartBandRepository extends JpaRepository<SmartBand, String> {
  public List<Activity> findByMac(String mac);
}
