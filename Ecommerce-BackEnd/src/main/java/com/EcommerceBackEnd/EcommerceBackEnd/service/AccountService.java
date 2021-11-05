package com.EcommerceBackEnd.EcommerceBackEnd.service;

import com.EcommerceBackEnd.EcommerceBackEnd.exception.DataNotFoundException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.DeleteDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.exception.UpdateDataFailException;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccount();

    public Account getAccountById(Long id);

//    public String getCurrentUsername();
//
//    public Account getAccountByUsername(String username) throws DataNotFoundException;

//    public void updateAccount(Account account) throws DataNotFoundException, UpdateDataFailException;

    public void updateAccountRoles(Account account) throws DataNotFoundException, UpdateDataFailException;

    public void deleteAccount(Long id) throws DeleteDataFailException;

//    public List<Account> getByNameContainting(String name);
}
