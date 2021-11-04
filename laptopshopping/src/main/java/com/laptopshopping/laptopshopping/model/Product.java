package com.laptopshopping.laptopshopping.model;

import com.laptopshopping.laptopshopping.model.enum_entity.ProductType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_name"})},
        indexes = {
                @Index(name = "product_index", columnList = "product_name, price")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    @NotBlank
    private String productName;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "price")
    @Min(value = 0)
    private Long price;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @NotNull
    private Brand brand;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Picture> PictureList = new ArrayList<>();

    @ManyToMany(mappedBy = "productList", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Tag> tagList = new ArrayList<>();

    @ManyToMany(mappedBy = "productList", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<SubCategory> subCategoriesList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratingList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItemList = new ArrayList<>();

    @Column(name = "rating")
    @Min(value = 0, message = "The star must be a positive integer")
    @Max(value = 5, message = "Maximum star is 5")
    private Float rating;

}
