package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sub_categories", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sub_category_name"})},
        indexes = {
                @Index(name = "sub_category_index", columnList = "sub_category_name")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private int subCategoryId;

    @Column(name = "sub_category_name")
    @NotNull
    private String subCategoryName;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_sub_categories",
            joinColumns = @JoinColumn(name = "sub_category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList = new ArrayList<>();

}
