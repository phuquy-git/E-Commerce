package com.EcommerceBackEnd.EcommerceBackEnd.converter;

import com.EcommerceBackEnd.EcommerceBackEnd.dto.ImageDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Image;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ImageConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ImageDTO convertToDto(Image image) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/public/image/")
                .path(image.getImageId())
                .toUriString();
        ImageDTO imageDTO = modelMapper.map(image, ImageDTO.class);
        imageDTO.setUrl(downloadURL);
        return imageDTO;
    }
}
