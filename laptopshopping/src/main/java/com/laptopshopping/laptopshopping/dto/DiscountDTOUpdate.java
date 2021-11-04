package com.laptopshopping.laptopshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTOUpdate {
    @NotNull
    private long discountId;

    private LocalDateTime starDate;

    private LocalDateTime endDate;

    private LocalDateTime updateDate;
}
