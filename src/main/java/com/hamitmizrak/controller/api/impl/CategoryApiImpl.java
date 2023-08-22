package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.assist.FrontEnt;
import com.hamitmizrak.business.dto.CategoryDto;
import com.hamitmizrak.business.services.ICategoryServices;
import com.hamitmizrak.controller.api.ICategoryApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

// API
@RestController
@RequestMapping("/category/api/v1")
@CrossOrigin(origins = FrontEnt.REACT_URL) // http://localhost:3000
public class CategoryApiImpl implements ICategoryApi<CategoryDto> {

    // Injection
    private final ICategoryServices iCategoryServices;
    private ApiResult apiResult;

    //
    @PostConstruct
    public void categoryPostConstruct() {
        apiResult = new ApiResult();
    }

    // CREATE
    // http://localhost:4444/category/api/v1/create
    @Override
    @PostMapping(value = "create")
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody CategoryDto categoryDto) {
        // return new ResponseEntity<>(iCategoryServices.categoryServiceCreate(categoryDto), HttpStatus.OK);
        // return  ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceCreate(categoryDto));
        // return  ResponseEntity.status(200).body(iCategoryServices.categoryServiceCreate(categoryDto));
        // return  ResponseEntity.ok().body(iCategoryServices.categoryServiceCreate(categoryDto));

        // iCategoryServices.categoryServiceCreate(categoryDto);
        // apiResult=new ApiResult("path","message",200);
        // return  ResponseEntity.ok().body(apiResult);
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    // LIST
    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiList() {
        return null;
    }

    // FIND
    @Override
    public ResponseEntity<CategoryDto> categoryApiFind(Long id) {
        return null;
    }

    // UPDATE
    @Override
    public ResponseEntity<CategoryDto> categoryApiUpdate(Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return null;
    }

    // DELETE
    @Override
    public ResponseEntity<CategoryDto> categoryApiDelete(Long id) {
        return null;
    }

    ///////////////////////////////////////////////////////////////
    // ALL DELETE
    @Override
    public ResponseEntity<String> categoryApiAllDelete() {
        return null;
    }

    // SPEED DATA
    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiSpeedData(int key) {
        return null;
    }
}
