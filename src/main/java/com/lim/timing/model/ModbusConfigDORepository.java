package com.lim.timing.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @BelongsProject: timing
 * @BelongsPackage: com.lim.timing.model
 * @Author: lim
 * @CreateTime: 2019-07-22 15:31
 * @Description: TODO
 */
public interface ModbusConfigDORepository extends JpaRepository<ModbusConfigDO, Integer> {

}