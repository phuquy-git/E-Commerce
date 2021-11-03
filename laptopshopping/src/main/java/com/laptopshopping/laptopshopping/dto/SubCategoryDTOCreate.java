package com.laptopshopping.laptopshopping.dto;

import javax.validation.constraints.NotNull;

public class SubCategoryDTOCreate {
    @NotNull
    private String subCategoryName;

    private String description;
}
