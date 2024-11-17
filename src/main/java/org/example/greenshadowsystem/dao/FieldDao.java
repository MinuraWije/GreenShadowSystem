package org.example.greenshadowsystem.dao;

import org.example.greenshadowsystem.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDao extends JpaRepository<FieldEntity,String> {
}
