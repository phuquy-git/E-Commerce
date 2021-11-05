package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface ImageService {
    public Image saveImage(MultipartFile file) throws IOException, CreateDataFailException;

    public com.EcommerceBackEnd.EcommerceBackEnd.model.Image getImageById(String image_id);

    public List<Image> getAllImages();
}
