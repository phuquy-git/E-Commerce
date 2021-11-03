package com.laptopshopping.laptopshopping.service;

import com.laptopshopping.laptopshopping.model.Picture;
import com.laptopshopping.laptopshopping.model.Product;

import java.util.List;

public interface PictureService {
    public List<Picture> getAllPictures();
    public Picture getPictureById(Integer id);
    public Picture createPicture(Product product, String path);
    public Picture updatePicture(Picture picture, String path);
    public void deletePicture(Picture picture);
}
