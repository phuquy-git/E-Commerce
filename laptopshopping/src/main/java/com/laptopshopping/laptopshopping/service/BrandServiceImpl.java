package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.constant.ErrorCode;
import com.laptopshopping.laptopshopping.constant.SuccessCode;
import com.laptopshopping.laptopshopping.dto.BrandDto;
import com.laptopshopping.laptopshopping.dto.ResponseDto;
import com.laptopshopping.laptopshopping.exception.BrandIdNotFoundException;
import com.laptopshopping.laptopshopping.exception.BrandNameNotFoundException;
import com.laptopshopping.laptopshopping.exception.SaveErrorException;
import com.laptopshopping.laptopshopping.model.Brand;
import com.laptopshopping.laptopshopping.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, BrandRepository manufacturerRepository,
                            ModelMapper mapper) {
        this.brandRepository = manufacturerRepository;
        this.modelMapper = mapper;
    }

    @Override
    public ResponseDto retrieveBrands() {
        ResponseDto responseDto = new ResponseDto();
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> brandsDtos = brands.stream().map(brand -> modelMapper.map(brand, BrandDto.class))
                .collect(Collectors.toList());
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_ALL_BRAND);
        responseDto.setData(brandsDtos);
        return null;
    }

    @Override
    public ResponseDto getBrandById(Integer id) throws BrandIdNotFoundException {
        ResponseDto responseDto = new ResponseDto();
        Brand brandById = brandRepository.findById(id)
                .orElseThrow(() -> new BrandIdNotFoundException((ErrorCode.ERROR_BRAND_ID_NOT_FOUND)));

        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_BRAND);
        responseDto.setData(brandById);
        return responseDto;
    }

    @Override
    public ResponseDto getBrandByName(String brandName) throws BrandNameNotFoundException{
        ResponseDto responseDto = new ResponseDto();
        Brand brandByBrandName = brandRepository.findByBrandName()
                .orElseThrow(() -> new BrandIdNotFoundException((ErrorCode.ERROR_BRAND_NAME_NOT_FOUND)));

        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_BRAND);
        responseDto.setData(brandByBrandName);
        return responseDto;
    }

    @Override
    public ResponseDto createBrand(BrandDto manufacturerDTO) {
        ResponseDto responseDto = new ResponseDto();

        Brand brand = brandRepository.findById(brand.getBrandId())
                .orElseThrow(() -> new BrandIdNotFoundException(ErrorCode.ERROR_BRAND_ID_NOT_FOUND));

        Brand brand = brandRepository.findById(brand.getBrandName())
                .orElseThrow(() -> new BrandIdNotFoundException(ErrorCode.ERROR_BRAND_NAME_NOT_FOUND));

        Brand brandSave = new Brand(brand.getBrandId(), brand.getBrandName(), brand.getLogoPath());
        try {
            brandSave = brandRepository.save(brandSave);
        } catch (Exception e) {
            throw new SaveErrorException(ErrorCode.ERROR_SAVE_BRAND);
        }
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_BRAND);
        responseDto.setData(Brand);
        return responseDto;
        return null;
    }

    @Override
    public ResponseDto updateBrand(int id, BrandDto manufacturerDTO) {
        return null;
    }

    @Override
    public ResponseDto deleteBrand(Brand brand) {
        return null;
    }

}
