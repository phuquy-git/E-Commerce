package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTOCreate {
    @Min(value = 0)
    private long discountPrice;

    private LocalDateTime starDate;

    private LocalDateTime endDate;

    @NotNull
    private String product;

    private LocalDateTime createDate;
}
