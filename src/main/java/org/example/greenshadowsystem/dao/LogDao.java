package org.example.greenshadowsystem.dao;

import org.example.greenshadowsystem.entity.impl.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<LogEntity,String> {
}
