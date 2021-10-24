package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating_score")
    @NotNull
    private int ratingScore;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
