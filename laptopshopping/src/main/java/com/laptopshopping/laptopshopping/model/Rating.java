package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings",
        indexes = {
                @Index(name = "comment_index", columnList = "rating_score, comment")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating_score")
    private int ratingScore;

    @Column(name = "rating_date")
    private LocalDateTime ratingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

}
