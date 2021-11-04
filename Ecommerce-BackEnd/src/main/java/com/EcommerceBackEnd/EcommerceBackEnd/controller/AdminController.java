package com.EcommerceBackEnd.EcommerceBackEnd.controller;

import com.EcommerceBackEnd.EcommerceBackEnd.constant.ErrorCode;
import com.EcommerceBackEnd.EcommerceBackEnd.constant.SuccessCode;
import com.EcommerceBackEnd.EcommerceBackEnd.converter.ImageConverter;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.ImageDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.ResponseDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    //Service
    @Autowired
    private ImageService imageService;

    //Converter
    @Autowired
    private ImageConverter imageConverter;

    //ImageController
    @PostMapping("/image/save")
    public ResponseEntity<ResponseDTO> uploadImage(@RequestParam("file") MultipartFile file) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Image image = imageService.saveImage(file);
            ImageDTO imageDTO = imageConverter.convertToDto(image);
            responseDTO.setData(imageDTO);
            responseDTO.setSuccessCode(SuccessCode.SUCCESS_IMAGE_SAVED);
        } catch (Exception e) {
            responseDTO.setData(null);
            responseDTO.setErrorCode(ErrorCode.ERROR_IMAGE_NOT_SAVED);
        }
        return ResponseEntity.ok().body(responseDTO);
    }

}
