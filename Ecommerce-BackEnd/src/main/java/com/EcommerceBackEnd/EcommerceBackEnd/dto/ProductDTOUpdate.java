package com.EcommerceBackEnd.EcommerceBackEnd.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class ProductDTOUpdate {
    @NotNull
    private long productId;

    @NotNull
    private String pname;

    @NotNull
    private String categoryName;

    private String image;

    @Min(value = 0)
    private long price;

    private String description;

    private String brandName;
}
