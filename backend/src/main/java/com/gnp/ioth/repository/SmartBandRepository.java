package com.gnp.ioth.repository;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartBandRepository extends JpaRepository<SmartBand, String> {

  List<Activity> findByMac(String mac);
}
