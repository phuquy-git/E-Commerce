package com.EcommerceBackEnd.EcommerceBackEnd.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BrandDTO {
    private long brandId;

    private String bname;

    private LocalDateTime createdIn;

    private LocalDateTime updatedIn;
}
