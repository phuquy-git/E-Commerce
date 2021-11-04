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
public class CategoryDTOCreate {
    @NotNull
    private String cname;

    private String description;
}
