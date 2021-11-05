package com.EcommerceBackEnd.EcommerceBackEnd.converter;

import com.EcommerceBackEnd.EcommerceBackEnd.dto.*;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Image;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import com.EcommerceBackEnd.EcommerceBackEnd.service.BrandService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.CategoryService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageConverter imageConverter;

    public ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setProductId(product.getProductId());
        productDTO.setCategoryName(product.getCategory().getCname());
        productDTO.setBrandName(product.getBrand().getBname());
        Image image = product.getImage();
        if (image != null) {
            ImageDTO imageDTO = imageConverter.convertToDto(image);
            productDTO.setImage(imageDTO.getUrl());
        }
        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO) throws DataNotFoundException {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setCategory(categoryService.getCategoryByName(productDTO.getCategoryName()));
        product.setBrand(brandService.getBrandByBname(productDTO.getBrandName()));
        return product;
    }

    public ProductDTOItem convertToDtoItem(Product product) {
        ProductDTOItem productDTOItem = modelMapper.map(product, ProductDTOItem.class);
        productDTOItem.setProductId(product.getProductId());
        Image image = product.getImage();
        if (image != null) {
            ImageDTO imageDTO = imageConverter.convertToDto(image);
            productDTOItem.setImage(imageDTO.getUrl());
        }
        return productDTOItem;
    }

    public Product convertToEntityCreate(ProductDTOCreate productDTOCreate) throws DataNotFoundException {
        Product product = modelMapper.map(productDTOCreate, Product.class);
        product.setCategory(categoryService.getCategoryByName(productDTOCreate.getCategoryName()));
        product.setBrand(brandService.getBrandByBname(productDTOCreate.getBrandName()));
        if (productDTOCreate.getImage() != null)
            product.setImage(imageService.getImageById(productDTOCreate.getImage()));
        return product;
    }

    public Product convertToEntityUpdate(ProductDTOUpdate productDTOUpdate) throws DataNotFoundException {
        Product product = modelMapper.map(productDTOUpdate, Product.class);
        product.setProductId(productDTOUpdate.getProductId());
        product.setCategory(categoryService.getCategoryByName(productDTOUpdate.getCategoryName()));
        product.setBrand(brandService.getBrandByBname(productDTOUpdate.getBrandName()));
        if (productDTOUpdate.getImage() != null)
            product.setImage(imageService.getImageById(productDTOUpdate.getImage()));
        return product;
    }
}
