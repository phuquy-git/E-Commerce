package com.laptopshopping.laptopshopping.service.Implement;

import com.laptopshopping.laptopshopping.constant.ErrorCode;
import com.laptopshopping.laptopshopping.exception.CreateDataFailException;
import com.laptopshopping.laptopshopping.model.Picture;
import com.laptopshopping.laptopshopping.model.Product;
import com.laptopshopping.laptopshopping.repository.PictureRepository;
import com.laptopshopping.laptopshopping.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    public Picture getPictureById(Integer id) {
        Optional<Picture> result = this.pictureRepository.findById(id);
        if(result.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return result.get();
    }

    public Picture createPicture(MultipartFile file) throws IOException, CreateDataFailException {
        Picture image = new Picture();
        image.setContentType(file.getContentType());
        image.setData(file.getBytes());
        image.setSize(file.getSize());

        try {
            Picture picture = pictureRepository.save(image);
            return picture;
        } catch (Exception e) {
            throw new CreateDataFailException(ErrorCode.ERROR_PICTURE_NOT_SAVED);
        }
    }

    public Picture updatePicture(Picture picture) {
        return null;
    }

    public void deletePicture(Integer id) {

    }


}
