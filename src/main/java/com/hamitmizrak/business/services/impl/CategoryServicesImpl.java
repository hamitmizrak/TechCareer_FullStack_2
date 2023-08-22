package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.CategoryDto;
import com.hamitmizrak.business.services.ICategoryServices;
import com.hamitmizrak.data.entity.CategoryEntity;
import com.hamitmizrak.data.repository.ICategoryRepository;
import com.hamitmizrak.exception.BlogNotFoundException;
import com.hamitmizrak.exception.HamitMizrakException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

// SERVICE
@Service
public class CategoryServicesImpl implements ICategoryServices<CategoryDto, CategoryEntity> {

    // Injection
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public CategoryDto entityToDto(CategoryEntity categoryEntity) {
        return modelMapperBean.modelMapperMethod().map(categoryEntity, CategoryDto.class);
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDto categoryDto) {
        return modelMapperBean.modelMapperMethod().map(categoryDto, CategoryEntity.class);
    }

    /////////////////////////////////////////////////////////////////////
    // CREATE
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceCreate(CategoryDto categoryDto) {
        if (categoryDto != null) {
            CategoryEntity dtoToEntityChange = dtoToEntity(categoryDto);
            CategoryEntity categoryEntity = iCategoryRepository.save(dtoToEntityChange);
            // kaydettikten sonra id alsın döndersin
            categoryDto.setId(categoryEntity.getCategoryId());
            categoryDto.setSystemDate(categoryEntity.getSystemDate());
        } else {
            throw new NullPointerException("Category Dto null");
        }
        return categoryDto;
    }

    // LIST
    @Override
    public List<CategoryDto> categoryServiceList() {
        // CategoryEntity List
        Iterable<CategoryEntity> categoryEntitiesList = iCategoryRepository.findAll();

        //CategoryDto List
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        // Bu döngü EntityList'i DtoList'e çevirsin
        for (CategoryEntity entity : categoryEntitiesList) {
            CategoryDto categoryDto = entityToDto(entity);
            categoryDtoList.add(categoryDto);
            // eğer Database maskelemek yapmak istiyorsak Bcrypted kullanabiliriz
        }
        return categoryDtoList;
    }

    // FIND
    @Override
    public CategoryDto categoryServiceFind(Long id) {
        // 1.YOL  optinal get , isPresent
        /*
        Optional<CategoryEntity> categoryFindEntity= iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDto(categoryFindEntity.get());
        if(categoryFindEntity.isPresent()){
            return categoryDto;
        }
        */

        // 2.YOL
        CategoryEntity categoryEntity = null;
        if (id != null && id != 0) {
            categoryEntity = iCategoryRepository.findById(id)
                    .orElseThrow(() -> new BlogNotFoundException(id + " Nolu ID Bulunmadı !!!!"));
        } else if (id == null)
            throw new HamitMizrakException("Category id bull değerdir");
        return entityToDto(categoryEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceUpdate(Long id, CategoryDto categoryDto) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null) {
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            categoryEntity.setCategoryName(categoryDto.getCategoryName());
            iCategoryRepository.save(categoryEntity);
        }
        return categoryDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceDelete(Long id) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null) {
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            iCategoryRepository.delete(categoryEntity);
        }
        return categoryFindDto;
    }

    //////////////////////////////////////////////////////////////////////////
    // ALL DELETE
    @Override
    public String categoryServiceAllDelete() {
        iCategoryRepository.deleteAll();
        return "Silinen veri sayısı: " + categoryServiceList().size();
    }

    // SPEED DATA
    @Override
    public List<CategoryDto> categoryServiceSpeedData(int key) {
        CategoryDto categoryDto = null;
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= key; i++) {
            categoryDto = new CategoryDto();
            categoryDto.setCategoryName("category adı: " + i);
            categoryDtoList.add(categoryDto);
            CategoryEntity categoryEntity=dtoToEntity(categoryDto);
            iCategoryRepository.save(categoryEntity);
            count++;
        }
        return categoryDtoList;
    }

} //end class
