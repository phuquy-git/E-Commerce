package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "brands", schema = "public",  uniqueConstraints = {@UniqueConstraint(columnNames = "brand_name")})
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "brand_name")
    @NotNull
    private String brandName;

    @Column(name = "logo_path")
    @NotNull
    private String logoPath;



}
