package com.EcommerceBackEnd.EcommerceBackEnd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "bname")
        }, indexes = {@Index(name = "brand_index", columnList = "brand_id, bname", unique = true)})
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true)
    private long brandId;

    @Column(name = "bname", nullable = false, unique = true)
    private String bname;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    @Column(name = "updated_in")
    private LocalDateTime updatedIn;

}
