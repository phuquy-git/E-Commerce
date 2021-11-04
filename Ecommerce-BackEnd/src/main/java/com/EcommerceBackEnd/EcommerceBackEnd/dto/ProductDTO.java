package com.EcommerceBackEnd.EcommerceBackEnd.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long productId;

    private String pname;

    private String categoryName;

    @Min(value = 0)
    private long price;

    private String image;

    @Min(value = 0, message = "The star must be a positive ingeter")
    @Max(value = 5, message = "Maximum star is 5")
    private Float rating;

    private LocalDateTime createdIn;

    private LocalDateTime updatedIn;

    private String description;

    private String brandName;
}
