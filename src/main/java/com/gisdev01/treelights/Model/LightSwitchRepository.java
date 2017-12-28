package com.gisdev01.treelights.Model;

import org.springframework.data.repository.CrudRepository;

public interface LightSwitchRepository extends CrudRepository<LightSwitch, Long> {

    @Override
    void delete(Long aLong);

}

