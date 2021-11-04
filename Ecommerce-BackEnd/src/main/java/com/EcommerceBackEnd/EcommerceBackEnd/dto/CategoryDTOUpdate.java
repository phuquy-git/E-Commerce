package com.EcommerceBackEnd.EcommerceBackEnd.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTOUpdate {
    @NotNull
    private long categoryId;

    private String description;
}
