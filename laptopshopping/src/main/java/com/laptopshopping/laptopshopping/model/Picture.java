package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures", schema = "public",
        indexes = {
                @Index(name = "picture_index", columnList = "picture_id")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "picture_id")
    private String pictureId;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "data", length = Integer.MAX_VALUE, nullable = false)
    private byte[] data;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "size")
    private Long size;

}
