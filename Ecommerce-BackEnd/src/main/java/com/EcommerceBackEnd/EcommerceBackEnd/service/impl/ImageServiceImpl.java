//package com.EcommerceBackEnd.EcommerceBackEnd.service.impl;
//
//import com.EcommerceBackEnd.EcommerceBackEnd.constant.ErrorCode;
//import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
//import com.EcommerceBackEnd.EcommerceBackEnd.model.Image;
//import com.EcommerceBackEnd.EcommerceBackEnd.repository.ImageRepository;
//import com.EcommerceBackEnd.EcommerceBackEnd.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ImageServiceImpl implements ImageService {
//    @Autowired
//    private ImageRepository imageRepository;
//
//    public Image getImageById(String image_id) {
//        Optional<Image> image = imageRepository.findById(image_id);
//        if (image.isPresent())
//            return image.get();
//        else
//            return null;
//    }
//
//    public List<Image> getAllImages() {
//        return imageRepository.findAll();
//    }
//
//    public Image saveImage(MultipartFile file) throws IOException, CreateDataFailException {
//        Image image = new Image();
//        image.setContentType(file.getContentType());
//        image.setData(file.getBytes());
//        image.setSize(file.getSize());
//
//        try {
//            Image img = imageRepository.save(image);
//            return img;
//        } catch (Exception e) {
//            throw new CreateDataFailException(ErrorCode.ERROR_IMAGE_NOT_SAVED);
//        }
//    }
//}
