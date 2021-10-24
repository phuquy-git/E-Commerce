package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private int pictureId;

    @Column(name = "picture_path")
    @NotNull
    private String picturePath;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product productId;

}
