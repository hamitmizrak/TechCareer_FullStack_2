package com.hamitmizrak.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
// Category (1) - Blog (N)
public class CategoryDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // CATEGORY
    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}")
    @Size(min=10,message = "{blog.category.least.validation.constraints.NotNull.message}")
    private String categoryName;
}
