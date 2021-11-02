package com.laptopshopping.laptopshopping.dto;

import com.laptopshopping.laptopshopping.model.Brand;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {

    @NotBlank
    private String brandName;

    private String logoPath;

}
