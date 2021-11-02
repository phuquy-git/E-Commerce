package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.dto.BrandDto;
import com.laptopshopping.laptopshopping.dto.ResponseDto;
import com.laptopshopping.laptopshopping.exception.BrandIdNotFoundException;
import com.laptopshopping.laptopshopping.model.Brand;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

public interface BrandService {
    public ResponseDto retrieveBrands();
    public ResponseDto getBrandById(Integer id) throws BrandIdNotFoundException;
    public ResponseDto getBrandByName(String brandName);
    public ResponseDto createBrand(@Valid BrandDto manufacturerDTO);
    public ResponseDto updateBrand(int id, @Valid BrandDto manufacturerDTO);
    public ResponseDto deleteBrand(Brand brand);
}