package com.laptopshopping.laptopshopping.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"category_name"})},
        indexes = {
                @Index(name = "category_name_index", columnList = "category_name")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    @NotBlank
    private String categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<SubCategory> subCategoriesList = new ArrayList<>();

    public Category(int categoryId, String categoryName, String description, List<SubCategory> subCategoriesList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.subCategoriesList = subCategoriesList;
    }
}
