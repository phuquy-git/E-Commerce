package com.EcommerceBackEnd.EcommerceBackEnd.converter;

import com.EcommerceBackEnd.EcommerceBackEnd.dto.RatingDTOPost;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.RatingDTOReview;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.RatingDTOShow;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Rating;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class RatingConverter {
    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    public RatingDTOPost convertToDto(Rating rating) {
        RatingDTOPost ratingDTOPost = modelMapper.map(rating, RatingDTOPost.class);
        ratingDTOPost.setRatingId(rating.getRatingId());
        ratingDTOPost.setProductId(rating.getProduct().getProductId());
        ratingDTOPost.setAccountId(rating.getAccount().getAccountId());
        return ratingDTOPost;
    }

    public Rating convertToEntity(RatingDTOPost ratingDTOPost) throws ParseException, DataNotFoundException {
        Rating rating = modelMapper.map(ratingDTOPost, Rating.class);
        rating.setAccount(accountService.getAccountById(ratingDTOPost.getAccountId()));
        rating.setProduct(productService.getProductById(ratingDTOPost.getProductId()));
        return rating;
    }

    public RatingDTOReview convertToDtoReview(Rating rating) {
        RatingDTOReview ratingDTOReview = modelMapper.map(rating, RatingDTOReview.class);
        ratingDTOReview.setRatingId(rating.getRatingId());
        ratingDTOReview.setAccountUsername(rating.getAccount().getUsername());
        return ratingDTOReview;
    }

    public RatingDTOShow convertToDtoShow(Rating rating) {
        RatingDTOShow ratingDTOShow = modelMapper.map(rating, RatingDTOShow.class);
        ratingDTOShow.setRatingId(rating.getRatingId());
        ratingDTOShow.setProductId(rating.getProduct().getProductId());
        ratingDTOShow.setPname(rating.getProduct().getPname());
        ratingDTOShow.setUsername(rating.getAccount().getUsername());
        return ratingDTOShow;
    }
}
