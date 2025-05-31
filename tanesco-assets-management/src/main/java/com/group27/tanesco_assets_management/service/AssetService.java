package com.group27.tanesco_assets_management.service;

import com.group27.tanesco_assets_management.model.Asset;
import com.group27.tanesco_assets_management.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}