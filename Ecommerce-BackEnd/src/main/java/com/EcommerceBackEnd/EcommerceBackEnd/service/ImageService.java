package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public Image saveImage(MultipartFile file) throws IOException, CreateDataFailException;

    public Image getImageById(String image_id);

    public List<Image> getAllImages();
}
