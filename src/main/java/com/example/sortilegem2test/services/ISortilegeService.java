package com.example.sortilegem2test.services;

import com.example.sortilegem2test.controller.SortilegeController;
import com.example.sortilegem2test.dto.SortilegeDto;
import com.example.sortilegem2test.entities.SortilegeEntity;

public interface ISortilegeService {

    public Integer ajouter(SortilegeEntity entity);
    public SortilegeEntity toEntity (SortilegeDto dto);
}
