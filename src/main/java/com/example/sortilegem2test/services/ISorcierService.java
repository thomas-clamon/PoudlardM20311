package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;

public interface ISorcierService {

    public SorcierDto toDto(SorcierEntity entity);
}
