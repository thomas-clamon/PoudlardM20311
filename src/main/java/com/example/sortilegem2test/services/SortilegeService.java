package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SortilegeDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import com.example.sortilegem2test.entities.SortilegeEntity;
import com.example.sortilegem2test.repositories.SorcierRepository;
import com.example.sortilegem2test.repositories.SortilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortilegeService implements ISortilegeService {

    @Autowired
    SortilegeRepository repository;

    @Autowired
    SorcierRepository sorcierRepository;

    @Override
    public Integer ajouter(SortilegeEntity entity) {
        repository.saveAndFlush(entity);
        return entity.getID();
    }

    @Override
    public SortilegeEntity toEntity(SortilegeDto dto) {
        SortilegeEntity entity = new SortilegeEntity();
        entity.setNom(dto.getNom());
        entity.setType_sors(dto.getType_sort());
        entity.setDate_sort(dto.getDate_sort());

        // ajouter
        SorcierEntity sorcier = sorcierRepository.findById(dto.getId_sorcier()).get();
        entity.setSorcier(sorcier);
        return entity;
    }
}
