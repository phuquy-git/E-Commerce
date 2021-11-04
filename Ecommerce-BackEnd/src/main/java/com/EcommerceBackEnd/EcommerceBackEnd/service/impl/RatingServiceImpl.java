package com.EcommerceBackEnd.EcommerceBackEnd.service.impl;

import com.EcommerceBackEnd.EcommerceBackEnd.constant.ErrorCode;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Rating;
import com.EcommerceBackEnd.EcommerceBackEnd.repository.RatingRepository;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ProductService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ProductService productService;

    public List<Rating> getAllRatings(){
        List<Rating> ratings = ratingRepository.findAll();
        if (ratings.isEmpty())
            return null;
        return ratings;
    }

    public Rating getRatingById(Long ratingId) throws DataNotFoundException {
        Optional<Rating> optionalRating = ratingRepository.findById(ratingId);
        if (optionalRating.isPresent())
            return optionalRating.get();
        else
            throw new DataNotFoundException(ErrorCode.ERROR_RATING_NOT_FOUND);
    }

    public Rating addRating(Rating rating) throws CreateDataFailException, UpdateDataFailException {
        //save rating
        rating.setDate(LocalDateTime.now());
        Rating saveRating = ratingRepository.save(rating);

        if (saveRating == null)
            throw new CreateDataFailException(ErrorCode.ERROR_RATING_NOT_SAVED);
        else {
            //update product rating
            Product product = rating.getProduct();
            productService.updateProduct(product);
            return saveRating;
        }
    }

    public void deleteRating(Long ratingId) throws DeleteDataFailException {
        try {
            //update product rating
            Rating rating = getRatingById(ratingId);
            Product product = productService.getProductById(rating.getProduct().getProductId());
            productService.updateProduct(product);
            //delete
            ratingRepository.deleteById(ratingId);
        } catch (Exception e) {
            throw new DeleteDataFailException(ErrorCode.ERROR_RATING_NOT_DELETED);
        }
    }

    public List<Rating> getRatingByProduct(Product product) {
        List<Rating> ratings = ratingRepository.findAllByProduct(product);
        if (ratings.isEmpty())
            return null;
        return ratings;
    }

    public List<Rating> getRatingByAccount(Account account) {
        List<Rating> ratings = ratingRepository.findAllByAccount(account);
        if (ratings.isEmpty())
            return null;
        return ratings;
    }
}
