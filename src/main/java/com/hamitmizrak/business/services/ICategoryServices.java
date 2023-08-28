package com.hamitmizrak.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ICategoryServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D categoryServiceCreate(D d);

    // LIST
    public List<D> categoryServiceList();

    // FIND BY
    public D categoryServiceFindById(Long id);

    // UPDATE
    public D categoryServiceUpdate(Long id,D d);

    // DELETE
    public D categoryServiceDeleteById(Long id);
}
