package com.EcommerceBackEnd.EcommerceBackEnd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "pname")
        }, indexes = {
                @Index(name = "product_idx" , columnList = "product_id , pname"),
                @Index(name = "product_categoryId_idx" , columnList = "category_id")
        })
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true)
    private long productId;

    @Column(name = "pname", nullable = false)
    private String pname;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Min(value = 0)
    @Column(name = "price")
    private long price;

    @Min(value = 0, message = "The star must be a positive ingeter")
    @Max(value = 5, message = "Maximum star is 5")
    @Column(name = "rating_star")
    private Float rating;

    //nhieu hinh anh
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    @Column(name = "updated_in")
    private LocalDateTime updatedIn;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
}
