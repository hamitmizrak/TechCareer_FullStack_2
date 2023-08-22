package com.hamitmizrak.data.entity;

import com.hamitmizrak.auditing.AuditingAwareBaseEntity;
import com.hamitmizrak.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@Log4j2
@ToString

// ENTITY
@Entity
@Table(name = "blogs")
// Blog(N) Categories(1)
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

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

    // RELATION
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    CategoryEntity relationCategoryEntity;

    // Constructor (Parametresiz)
    public BlogEntity() {
    }

    // Constructor (Parametreli)
    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }
}
