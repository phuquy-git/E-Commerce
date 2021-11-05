package com.EcommerceBackEnd.EcommerceBackEnd.controller;

import com.EcommerceBackEnd.EcommerceBackEnd.constant.SuccessCode;
import com.EcommerceBackEnd.EcommerceBackEnd.converter.AccountConverter;
import com.EcommerceBackEnd.EcommerceBackEnd.converter.RatingConverter;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.AccountDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.RatingDTOPost;
import com.EcommerceBackEnd.EcommerceBackEnd.dto.ResponseDTO;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.CreateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Rating;
import com.EcommerceBackEnd.EcommerceBackEnd.service.AccountService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.ImageService;
import com.EcommerceBackEnd.EcommerceBackEnd.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserController {
    //Service
    @Autowired
    private RatingService ratingService;

//    @Autowired
//    private ImageService imageService;

    @Autowired
    private AccountService accountService;

    //Converter
    @Autowired
    private RatingConverter ratingConverter;

    @Autowired
    private AccountConverter accountConverter;

    //RatingController
    @PostMapping(value = "/rating/save")
    public ResponseEntity<ResponseDTO> saveRating(@Valid @RequestBody RatingDTOPost ratingDTOPost) throws DataNotFoundException, CreateDataFailException, UpdateDataFailException, ParseException {
        ResponseDTO responseDTO = new ResponseDTO();
        Rating rating = ratingConverter.convertToEntity(ratingDTOPost);
        ratingService.addRating(rating);
        responseDTO.setData(ratingConverter.convertToDto(rating));
        responseDTO.setSuccessCode(SuccessCode.SUCCESS_RATING_SAVED);
        return ResponseEntity.ok().body(responseDTO);
    }

    //AccountController
//    @PutMapping("/account/update")
//    public ResponseEntity<ResponseDTO> updateAccount(@Valid @RequestBody AccountDTO accountDTO) throws DataNotFoundException, UpdateDataFailException, ParseException {
//        ResponseDTO responseDTO = new ResponseDTO();
//        Account account = accountConverter.convertToEntity(accountDTO);
//        accountService.updateAccount(account);
//        responseDTO.setData(accountConverter.convertToDto(account));
//        responseDTO.setSuccessCode(SuccessCode.SUCCESS_USER_UPDATED);
//        return ResponseEntity.ok().body(responseDTO);
//    }
}
