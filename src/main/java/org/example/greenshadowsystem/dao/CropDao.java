package org.example.greenshadowsystem.dao;

import org.example.greenshadowsystem.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropDao extends JpaRepository<CropEntity,String> {
}
