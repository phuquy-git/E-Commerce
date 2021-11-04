package com.EcommerceBackEnd.EcommerceBackEnd.service.impl;

import com.EcommerceBackEnd.EcommerceBackEnd.constant.ErrorCode;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Brand;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import com.EcommerceBackEnd.EcommerceBackEnd.repository.BrandRepository;
import com.EcommerceBackEnd.EcommerceBackEnd.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductService productService;

    public List<Brand> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        if (brands.isEmpty())
            return null;
        else return brands;
    }

    public Brand getBrandById(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.orElse(null);
    }

    public Brand getBrandByBname(String bname) {
        Optional<Brand> brand = brandRepository.findByBname(bname);
        return brand.orElse(null);
    }

    public Brand addBrand(Brand brand) throws CreateDataFailException {
        try {
            brand.setCreatedIn(LocalDateTime.now());
            return brandRepository.save(brand);
        } catch (Exception ex) {
            throw new CreateDataFailException(ErrorCode.ERROR_BRAND_NOT_SAVED);
        }
    }

    public void updateBrand(Brand brand) throws UpdateDataFailException {
        try {
            Brand currentBrand = getBrandById(brand.getBrandId());
            currentBrand.setUpdatedIn(LocalDateTime.now());
            brandRepository.save(currentBrand);
        } catch (Exception ex) {
            throw new UpdateDataFailException(ErrorCode.ERROR_BRAND_NOT_UPDATED);
        }
    }

    public void deleteBrand(Long id) throws DeleteDataFailException {
        try {
            Brand brand = getBrandById(id);
            //delete all products
            List<Product> products = productService.getProductByBrand(brand);
            if (products != null) {
                for (Product product : products)
                    productService.deleteProduct(product.getProductId());
            }
            //delete brand
            brandRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteDataFailException(ErrorCode.ERROR_BRAND_NOT_DELETED);
        }
    }

    public List<Brand> getByNameContainting(String name) {
        List<Brand> brands = brandRepository.findByBnameContainingIgnoreCase(name);
        if (brands.isEmpty())
            return null;
        else return brands;
    }
}
