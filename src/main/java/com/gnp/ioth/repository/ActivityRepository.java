package com.gnp.ioth.repository;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

  List<Activity> findBySmartBand(SmartBand smartBand);

  List<Activity> findBySmartBandAndTimestampAfterOrderByTimestampAsc(SmartBand smartBand,
    Timestamp timestamp);

  List<Activity> findBySmartBandAndTimestampBetweenOrderByTimestampAsc(
    SmartBand smartBand, Timestamp timestamp, Timestamp timestamp2);
}
