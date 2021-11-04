package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Mod10Check;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int productId;

    private String productName;

    private String description;

    private String brandName;

    private String subCategoryName;

    private String Picture;

    @Min(value = 0)
    private long price;

    @Min(value = 0, message = "The star must be a positive integer")
    @Max(value = 5, message = "Maximum star is 5")
    private Float rating;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
