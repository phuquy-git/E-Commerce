package com.laptopshopping.laptopshopping.controller;

import com.laptopshopping.laptopshopping.constant.SuccessCode;
import com.laptopshopping.laptopshopping.converter.BrandCoverter;
import com.laptopshopping.laptopshopping.dto.BrandDTO;
import com.laptopshopping.laptopshopping.dto.BrandDTOCreate;
import com.laptopshopping.laptopshopping.dto.BrandDTOUpdate;
import com.laptopshopping.laptopshopping.dto.ResponseDTO;
import com.laptopshopping.laptopshopping.exception.CreateDataFailException;
import com.laptopshopping.laptopshopping.exception.DeleteDataFailException;
import com.laptopshopping.laptopshopping.exception.UpdateDataFailException;
import com.laptopshopping.laptopshopping.model.Brand;
import com.laptopshopping.laptopshopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private BrandService brandService;
    private BrandCoverter brandCoverter;

    @Autowired
    public BrandController(BrandService brandService, BrandCoverter brandCoverter) {
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDTO> createBrand(@Valid @RequestBody BrandDTOCreate brandDTOCreate)
            throws ParseException, CreateDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        Brand brand = brandCoverter.convertToEntityCreate(brandDTOCreate);
        Brand createBrand = brandService.createBrand(brand);
        responseDTO.setData(brandCoverter.convertToDto(createBrand));
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
    public ResponseEntity<ResponseDTO> deleteBrand(@PathVariable Integer id) throws DeleteDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        brandService.deleteBrand(id);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_BRAND_DELETED);
        return ResponseEntity.ok().body(responseDTO);
    }
}
