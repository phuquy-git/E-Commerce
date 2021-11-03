package com.laptopshopping.laptopshopping.controller;

import com.laptopshopping.laptopshopping.constant.ErrorCode;
import com.laptopshopping.laptopshopping.constant.SuccessCode;
import com.laptopshopping.laptopshopping.converter.PictureConverter;
import com.laptopshopping.laptopshopping.dto.PictureDTO;
import com.laptopshopping.laptopshopping.dto.ResponseDTO;
import com.laptopshopping.laptopshopping.model.Picture;
import com.laptopshopping.laptopshopping.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/pictures")
public class PictureController {
    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        super();
        this.pictureService = pictureService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDTO> uploadPicture(@RequestParam("file") MultipartFile file) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Picture picture = pictureService.createPicture(file);
            PictureDTO pictureDTO = PictureConverter.convertToDto(picture);
            responseDTO.setData(pictureDTO);
            responseDTO.setSuccessCode(SuccessCode.SUCCESS_PICTURE_SAVED);
        } catch (Exception e) {
            responseDTO.setData(null);
            responseDTO.setErrorCode(ErrorCode.ERROR_PICTURE_NOT_SAVED);
        }
        return ResponseEntity.ok().body(responseDTO);
    }

}
