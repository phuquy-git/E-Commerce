package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Rating;

import java.util.List;

public interface RatingService {
    public List<Rating> getAllRatings();

    public Rating getRatingById(Long ratingId) throws DataNotFoundException;

    public Rating addRating(Rating rating) throws CreateDataFailException, DataNotFoundException, UpdateDataFailException;

    public void deleteRating(Long ratingId) throws DeleteDataFailException;

    public List<Rating> getRatingByProduct(Product product) throws DataNotFoundException;

    public List<Rating> getRatingByAccount(Account account) throws DataNotFoundException;
}
