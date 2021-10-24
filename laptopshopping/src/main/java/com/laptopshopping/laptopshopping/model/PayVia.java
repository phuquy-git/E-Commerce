package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pay_via", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayVia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_via_id")
    private int payViaId;

    @Column(name = "pay_type")
    @NotNull
    private String payType;

    @Column(name = "info")
    @NotNull
    private String info;
}
