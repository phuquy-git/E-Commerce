package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Struct;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOCreate {
    @NotNull
    private String productName;

    @NotNull
    private String subCategoryName;

    @Min(value = 0)
    private long price;

    private String Picture;

    private String description;

    @NotNull
    private String brandName;
}
