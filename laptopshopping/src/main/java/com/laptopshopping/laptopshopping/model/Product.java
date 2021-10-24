package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "products", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detail_description")
    private String detailDescription;

    @Column(name = "technical_description")
    private String technicalDescription;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    private Brand brand;

    @Column(name = "rating")
    private double rating;

    @ManyToMany(mappedBy = "product")
    Set<Category> categories;

    @ManyToMany(mappedBy = "tag")
    Set<Tag> tags;

    @OneToMany(mappedBy = "product")
    Set<CartItem> quantity;

}
