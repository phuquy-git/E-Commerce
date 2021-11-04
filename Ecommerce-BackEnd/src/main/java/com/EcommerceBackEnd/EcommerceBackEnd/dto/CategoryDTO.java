package com.EcommerceBackEnd.EcommerceBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private long categoryId;

    private String cname;

    private String description;

    private LocalDateTime createdIn;

    private LocalDateTime updatedIn;
}
