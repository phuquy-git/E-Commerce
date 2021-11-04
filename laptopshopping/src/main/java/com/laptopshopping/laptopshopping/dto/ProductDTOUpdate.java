package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOUpdate {
    @NotNull
    private int productId;

    @NotNull
    private String productName;

    @NotNull
    private String subCategoryName;

    private String Picture;

    @Min(value = 0)
    private long price;

    private String description;

    @NotNull
    private String brandName;
}
