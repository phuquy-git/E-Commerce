package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures", schema = "public",
        indexes = {
                @Index(name = "picture_index", columnList = "picture_id, picture_path")
        })
@Getter
@Setter
@NoArgsConstructor
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private int pictureId;

    @Column(name = "picture_path")
    private String picturePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    public Picture(int pictureId, String picturePath, Product product) {
        this.pictureId = pictureId;
        this.picturePath = picturePath;
        this.product = product;
    }
}
