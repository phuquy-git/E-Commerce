package com.laptopshopping.laptopshopping.controller;

import com.laptopshopping.laptopshopping.constant.SuccessCode;
import com.laptopshopping.laptopshopping.converter.BrandCoverter;
import com.laptopshopping.laptopshopping.dto.BrandDTO;
import com.laptopshopping.laptopshopping.dto.BrandDTOCreate;
import com.laptopshopping.laptopshopping.dto.BrandDTOUpdate;
import com.laptopshopping.laptopshopping.dto.ResponseDTO;
import com.laptopshopping.laptopshopping.model.Brand;
import com.laptopshopping.laptopshopping.model.Product;
import com.laptopshopping.laptopshopping.service.BrandService;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private BrandService brandService;
    private BrandCoverter brandCoverter;

    @Autowired
    public BrandController(BrandService brandService, BrandCoverter brandCoverter;) {
        super();
        this.brandService = brandService;
        this.brandCoverter = brandCoverter;
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllBrand() {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Brand> brands = brandService.getAllBrands();
        List<BrandDTO> brandDTOs = new ArrayList<>();
        if (brandDTOs != null) {
            for (Brand brand : brands)
                brandDTOs.add(brandCoverter.convertToDto(brand));
        }
        responseDTO.setData(brandDTOs);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_FOUND);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getBrandById() {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Brand> brands = brandService.getBrandById();
        List<BrandDTO> brandDTOs = new ArrayList<>();
        if (brandDTOs != null) {
            for (Brand brand : brands)
                brandDTOs.add(brandCoverter.convertToDto(brand));
        }
        responseDTO.setData(brandDTOs);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_FOUND);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/getproducts")
    public ResponseEntity<ResponseDTO> getProductByBrandId();
        ResponseDTO responseDTO = new ResponseDTO();
        List<Brand> brands = brandService.getBrandById();
        List<ProductDTO> productDTOs = new ArrayList<>();
        try {
            if(productDTOs != null) {
                for (Product product : products)
                    productDTOs.add(productCoverter.ConvertToDto(brand));
            } catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }responseDTO.setData(productDTOs);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDTO> createBrand(@Valid @RequestBody BrandDTOCreate brandDTOCreate)
            throws ParseException, CreateDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        Brand brand = brandCoverter.convertToEntityCreate(brandDTOCreate);
        Brand saveBrand = brandService.createBrand(brand);
        responseDTO.setData(brandCoverter.convertToDto(saveBrand));
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_SAVED);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateBrand(@Valid @RequestBody BrandDTOUpdate brandDTOUpdate)
            throws UpdateDataFailException, ParseException {
        ResponseDTO responseDTO = new ResponseDTO();
        Brand brand = brandCoverter.convertToEntityUpdate(brandDTOUpdate);
        brandService.updateBrand(brand);
        responseDTO.setData(brandCoverter.convertToDto(brand));
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_UPDATED);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteBrand(@PathVariable Long brandId) throws DeleteDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        brandService.deleteBrand(brandId);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_DELETED);
        return ResponseEntity.ok().body(responseDTO);
    }
}
