package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.model.Brand;

import java.util.List;

public interface BrandService {

    public List<Brand> getAllBrands();

    public Brand getBrandById(Integer id);

    public Brand getBrandByName(String brandName);

    public Brand createBrand(String brandName, String logoPath);

    public void updateBrand(Brand brand, String brandName, String logoPath);

    public void deleteBrand(Brand brand);

}