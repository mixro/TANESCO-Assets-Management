package com.group27.tanesco_assets_management.controller;

import com.group27.tanesco_assets_management.model.Asset;
import com.group27.tanesco_assets_management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalAssets", assetService.getAllAssets().size());
        return "index";
    }

    @GetMapping("/assets")
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.getAllAssets());
        return "assets-list";
    }

    @GetMapping("/assets/new")
    public String createAssetForm(Model model) {
        model.addAttribute("asset", new Asset());
        return "asset-form";
    }

    @PostMapping("/assets")
    public String saveAsset(@ModelAttribute Asset asset) {
        assetService.saveAsset(asset);
        return "redirect:/assets";
    }

    @GetMapping("/assets/edit/{id}")
    public String editAssetForm(@PathVariable Long id, Model model) {
        model.addAttribute("asset", assetService.getAssetById(id).orElse(new Asset()));
        return "asset-form";
    }

    @GetMapping("/assets/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return "redirect:/assets";
    }
}