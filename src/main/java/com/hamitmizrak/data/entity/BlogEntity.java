package com.hamitmizrak.data.entity;

import com.hamitmizrak.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// ENTITY
@Entity
@Table(name = "blogs")
// Blog(N) Categories(1)
public class BlogEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long blogId;

    // EMBEDDABLE
    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable = new BlogEntityEmbeddable();

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    // Database olmasın ama Javada olsun
   /*
   @Transient
    private String justJava;
    */
}
