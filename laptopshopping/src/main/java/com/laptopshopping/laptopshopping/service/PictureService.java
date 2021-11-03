package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.exception.CreateDataFailException;
import com.laptopshopping.laptopshopping.model.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PictureService {
    public List<Picture> getAllPictures();
    public Picture getPictureById(Integer id);
    public Picture createPicture(MultipartFile file) throws IOException, CreateDataFailException;
    public Picture updatePicture(Picture picture);
    public void deletePicture(Integer id);
}
