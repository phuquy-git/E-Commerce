package com.laptopshopping.laptopshopping.dto;

import javax.validation.constraints.NotNull;

public class SubCategoryDTOUpdate {
    @NotNull
    private long subCategoryId;

    private String description;
}
