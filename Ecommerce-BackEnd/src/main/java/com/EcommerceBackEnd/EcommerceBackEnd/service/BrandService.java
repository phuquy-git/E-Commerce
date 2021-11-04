package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Brand;
import java.util.List;

public interface BrandService {
    public List<Brand> getAllBrands();

    public Brand getBrandById(Long id);

    public Brand getBrandByBname(String bname);

    public Brand addBrand(Brand brand) throws CreateDataFailException;

    public void updateBrand(Brand brand) throws UpdateDataFailException;

    public void deleteBrand(Long id) throws DeleteDataFailException;

    public List<Brand> getByNameContainting(String name);
}
