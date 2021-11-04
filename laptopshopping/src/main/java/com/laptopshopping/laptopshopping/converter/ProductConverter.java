package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.ProductDTO;
import com.laptopshopping.laptopshopping.dto.ProductDTOCreate;
import com.laptopshopping.laptopshopping.dto.ProductDTOUpdate;
import com.laptopshopping.laptopshopping.model.Product;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setProductId(product.getProductId());
        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO) throws ParseException {
        Product product = modelMapper.map(productDTO, Product.class);
        return product;
    }

    public Product convertToEntityCreate(ProductDTOCreate productDTOCreate) throws ParseException {
        Product product = modelMapper.map(productDTOCreate, Product.class);
        return product;
    }

    public Product convertToEntityUpdate(ProductDTOUpdate productDTOUpdate) throws ParseException {
        Product product = modelMapper.map(productDTOUpdate, Product.class);
        return product;
    }
}
