package com.laptopshopping.laptopshopping.service.Implement;

import com.laptopshopping.laptopshopping.constant.ErrorCode;
import com.laptopshopping.laptopshopping.exception.CreateDataFailException;
import com.laptopshopping.laptopshopping.exception.DeleteDataFailException;
import com.laptopshopping.laptopshopping.exception.UpdateDataFailException;
import com.laptopshopping.laptopshopping.model.Brand;
import com.laptopshopping.laptopshopping.model.Product;
import com.laptopshopping.laptopshopping.repository.BrandRepository;
import com.laptopshopping.laptopshopping.repository.ProductRepository;
import com.laptopshopping.laptopshopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    private ProductRepository productRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ProductRepository productRepository) {
        super();
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    public List<Brand> getAllBrands() {
        return this.brandRepository.findAll();
    }

    public Brand getBrandById(Integer id) throws EntityNotFoundException{
        Optional<Brand> result = this.brandRepository.findById(id);
        if(result.isEmpty())
            throw new EntityNotFoundException();
        return result.get();
    }

    public Brand getBrandByName(String brandName)
            throws EntityNotFoundException{
        Optional<Brand> result = this.brandRepository.findByBrandName(brandName);
        if(result.isEmpty())
            throw new EntityNotFoundException();
        return result.get();
    }

    @Override
    public Brand createBrand(Brand brand) throws CreateDataFailException {
        try { return brandRepository.save(brand);
        } catch (Exception ex) {
            throw new CreateDataFailException(ErrorCode.ERROR_BRAND_NOT_SAVED);
        }
    }

    @Override
    public void updateBrand(Brand brand)
            throws UpdateDataFailException {
        try {
            Brand currentBrand = getBrandById(brand.getBrandId());
            brandRepository.save(currentBrand);
        } catch (Exception ex) {
            throw new UpdateDataFailException(ErrorCode.ERROR_BRAND_NOT_UPDATED);
        }
    }

    public void deleteBrand(Integer id) throws DeleteDataFailException {
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
}

