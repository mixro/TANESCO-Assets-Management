package com.group27.tanesco_assets_management.repository;

import com.group27.tanesco_assets_management.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}