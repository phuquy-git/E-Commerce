package com.EcommerceBackEnd.EcommerceBackEnd.facade;

import org.springframework.security.core.Authentication;
/**
 * This interface is used to retrieve authentication information.
 */
public interface IAuthenticationFacade {
    Authentication getAuthentication();
}