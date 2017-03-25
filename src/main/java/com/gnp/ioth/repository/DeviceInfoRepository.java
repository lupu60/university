package com.gnp.ioth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnp.ioth.model.DeviceInfo;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long>{

}
