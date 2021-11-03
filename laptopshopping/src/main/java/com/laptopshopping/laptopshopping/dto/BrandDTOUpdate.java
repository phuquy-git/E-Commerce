package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTOUpdate {

    @NotNull
    private Integer brandId;

    @NotNull
    private String logoPath;

}