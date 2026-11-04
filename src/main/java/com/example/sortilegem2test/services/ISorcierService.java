package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import com.example.sortilegem2test.entities.SortilegeEntity;

public interface ISorcierService {

    public SorcierDto toDto(SorcierEntity entity);

    public Integer nbPoint(SorcierEntity sorcier);

    public Boolean exist (Integer id);

}
