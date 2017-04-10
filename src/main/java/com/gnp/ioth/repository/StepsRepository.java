package com.gnp.ioth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.model.Steps;


@Repository
public interface StepsRepository extends JpaRepository<Steps, Long> {
  public List<Steps> findBySmartBand(SmartBand smartband);
}
