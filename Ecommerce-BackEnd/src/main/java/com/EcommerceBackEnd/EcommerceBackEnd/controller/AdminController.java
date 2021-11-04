package com.EcommerceBackEnd.EcommerceBackEnd.controller;

import com.EcommerceBackEnd.EcommerceBackEnd.constant.ErrorCode;
import com.EcommerceBackEnd.EcommerceBackEnd.constant.SuccessCode;
import com.EcommerceBackEnd.EcommerceBackEnd.converter.CategoryConverter;
import com.EcommerceBackEnd.EcommerceBackEnd.converter.ImageConverter;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.*;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Category;
import com.EcommerceBackEnd.EcommerceBackEnd.service.CategoryService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    //Service
    @Autowired
    private ImageService imageService;

    @Autowired
    private CategoryService categoryService;

    //Converter
    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private CategoryConverter categoryConverter;

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

    //CategoryController
    @GetMapping("/category")
    public ResponseEntity<ResponseDTO> findAllCategory() throws DataNotFoundException {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories)
                categoryDTOs.add(categoryConverter.convertToDto(category));
        }
        responseDTO.setData(categoryDTOs);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_CATEGORY_FOUND);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping(value = "/category/save")
    public ResponseEntity<ResponseDTO> saveCategory(@Valid @RequestBody CategoryDTOCreate categoryDTOCreate) throws ParseException, CreateDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        Category category = categoryConverter.convertToEntityCreate(categoryDTOCreate);
        Category saveCategory = categoryService.addCategory(category);
        responseDTO.setData(categoryConverter.convertToDto(saveCategory));
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_CATEGORY_SAVED);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PutMapping(value = "/category/update")
    public ResponseEntity<ResponseDTO> updateCategory(@Valid @RequestBody CategoryDTOUpdate categoryDTOUpdate) throws UpdateDataFailException, ParseException {
        ResponseDTO responseDTO = new ResponseDTO();
        Category category = categoryConverter.convertToEntityUpdate(categoryDTOUpdate);
        categoryService.updateCategory(category);
        responseDTO.setData(categoryConverter.convertToDto(category));
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_CATEGORY_SAVED);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping(value = "/category/delete/{categoryId}")
    public ResponseEntity<ResponseDTO> deleteCategory(@PathVariable Long categoryId) throws DeleteDataFailException {
        ResponseDTO responseDTO = new ResponseDTO();
        categoryService.deleteCategory(categoryId);
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_PRODUCT_DELETED);
        return ResponseEntity.ok().body(responseDTO);
    }

}
