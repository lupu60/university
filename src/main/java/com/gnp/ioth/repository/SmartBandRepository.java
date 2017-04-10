package com.gnp.ioth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnp.ioth.model.SmartBand;

@Repository
public interface SmartBandRepository extends JpaRepository<SmartBand, Long> {

}
