package com.laptopshopping.laptopshopping.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands", schema = "public",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"brand_name"})},
        indexes = {
        @Index(name = "brand_index", columnList = "brand_name")})
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name")
    @NotBlank
    private String brandName;

    @Column(name = "logo_path")
    private String logoPath;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

}
