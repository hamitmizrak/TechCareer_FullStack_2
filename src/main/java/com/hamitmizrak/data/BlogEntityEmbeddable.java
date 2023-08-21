package com.hamitmizrak.data;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

@Embeddable
public class BlogEntityEmbeddable {

    // HEADER
    @Column(name = "header", length = 500, columnDefinition = "varchar(500) default 'başlık yazılmadı...'")
    private String header;

    // CONTENT
    @Lob
    private String content;

    // IMAGE
    private String image;

    // TITLE
    private String title;
}
