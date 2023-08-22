package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Generics
// D: Dto
public interface ICategoryApi<D> {

    // CRUD
    // CREATE
    public ResponseEntity<?>  categoryApiCreate(D d);

    // LIST
    public ResponseEntity<?> categoryApiList();

    // FIND
    public ResponseEntity<?> categoryApiFind(Long id);

    // UPDATE
    public ResponseEntity<?> categoryApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?> categoryApiDelete(Long id);

    ////////////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<String> categoryApiAllDelete();

    // SPEED DATA
    public  ResponseEntity<List<CategoryDto>> categoryApiSpeedData(int key);
}
