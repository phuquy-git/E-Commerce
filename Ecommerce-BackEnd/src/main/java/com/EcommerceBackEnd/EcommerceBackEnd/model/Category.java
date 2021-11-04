package com.EcommerceBackEnd.EcommerceBackEnd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cname")
        }, indexes = { @Index(name = "category_idx" , columnList = "category_id , cname") })
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true)
    private long categoryId;

    @Column(name = "cname", nullable = false)
    private String cname;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    @Column(name = "updated_in")
    private LocalDateTime updatedIn;
}
