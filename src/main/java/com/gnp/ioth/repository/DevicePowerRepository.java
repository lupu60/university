package com.gnp.ioth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gnp.ioth.model.DevicePower;

@Repository
public interface DevicePowerRepository extends CrudRepository<DevicePower, Long> {
}
