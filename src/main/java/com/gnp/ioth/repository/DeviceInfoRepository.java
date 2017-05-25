package com.gnp.ioth.repository;

import com.gnp.ioth.model.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long> {

}
