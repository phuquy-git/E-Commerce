package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shippings", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ship_via_id")
    private int shipViaId;

    @Column(name = "ship_type")
    @NotNull
    private String shipType;

    @Column(name = "info")
    @NotNull
    private String info;
}
