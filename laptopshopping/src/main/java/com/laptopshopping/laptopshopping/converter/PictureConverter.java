package com.laptopshopping.laptopshopping.converter;

import com.laptopshopping.laptopshopping.dto.PictureDTO;
import com.laptopshopping.laptopshopping.model.Picture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;

@Component
public class PictureConverter {
    @Autowired
    private ModelMapper modelMapper;

    public PictureDTO convertToDto(Picture picture) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/public/picture/")
                .path(picture.getPictureId())
                .toUriString();
        PictureDTO PictureDTO = modelMapper.map(picture, PictureDTO.class);
        PictureDTO.setPicturePath(downloadURL);
        return PictureDTO;
    }
}