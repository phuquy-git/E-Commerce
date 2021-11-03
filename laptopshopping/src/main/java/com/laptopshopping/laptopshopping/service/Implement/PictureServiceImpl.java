package com.laptopshopping.laptopshopping.service.Implement;

import com.laptopshopping.laptopshopping.model.Picture;
import com.laptopshopping.laptopshopping.model.Product;
import com.laptopshopping.laptopshopping.repository.PictureRepository;
import com.laptopshopping.laptopshopping.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;


    @Override
    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture getPictureById(Integer id) {
        Optional<Picture> result = this.pictureRepository.findById(id);
        if(result.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return result.get();
    }

    @Override
    public Picture createPicture(Product product, String path) {
        return null;
    }

    @Override
    public Picture updatePicture(Picture picture, String path) {
        return null;
    }

    @Override
    public void deletePicture(Picture picture) {

    }
}
