package org.example.greenshadowsystem.dao;

import org.example.greenshadowsystem.entity.impl.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<StaffEntity,String> {
}
