package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.exception.CreateDataFailException;
import com.laptopshopping.laptopshopping.exception.DeleteDataFailException;
import com.laptopshopping.laptopshopping.exception.UpdateDataFailException;
import com.laptopshopping.laptopshopping.model.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getAllBrands();

    public Brand getBrandById(Integer id);

    public Brand getBrandByName(String brandName);

    public Brand createBrand(Brand brand) throws CreateDataFailException;;

    public void updateBrand(Brand brand) throws UpdateDataFailException;

    public void deleteBrand(Integer id) throws DeleteDataFailException;
}