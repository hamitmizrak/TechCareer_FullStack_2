package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.CategoryDto;

import java.util.List;

// Generics
// D: Dto
// E: Entity
public interface ICategoryServices<D,E> {

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    // CRUD
    // CREATE
    public D categoryServiceCreate(D d);

    // LIST
    public List<D> categoryServiceList();

    // FIND
    public D categoryServiceFind(Long id);

    // UPDATE
    public D categoryServiceUpdate(Long id,D d);

    // DELETE
    public D categoryServiceDelete(Long id);

    ////////////////////////////////////////////
    // ALL DELETE
    public String categoryServiceAllDelete();

    // SPEED DATA
    public  List<CategoryDto>  categoryServiceSpeedData(int key);
}
