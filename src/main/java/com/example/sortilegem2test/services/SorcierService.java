package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import com.example.sortilegem2test.entities.SortilegeEntity;
import com.example.sortilegem2test.enumation.TypeSort;
import com.example.sortilegem2test.repositories.SorcierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class SorcierService implements ISorcierService {

    @Autowired
    SorcierRepository repository;

    @Override
    public SorcierDto toDto(SorcierEntity entity) {
        SorcierDto dto = new SorcierDto();

        // on calcule le display name
        dto.setDisplay_name(entity.getPrenom().toUpperCase()
                + " "
                + entity.getNom().toUpperCase());

        // on calcule l'age
        Integer age = Period.between(entity.getDate_naissance(), LocalDate.now()).getYears();
        dto.setAge(age);

        // on affecte la maison
        dto.setMaison(entity.getMaison().getNom());

        return dto;
    }

    @Override
    public Integer nbPoint(SorcierEntity sorcier) {
        // On recupere la liste de sort
        List<SortilegeEntity> sorts = sorcier.getList_sortilege();

        if (sorts.equals(null) || sorts.size() == 0)
            return 0;
        Integer nbPoint = 0;
        for (int i = 0; i < sorts.size(); i++) {
            TypeSort type_sort = TypeSort.valueOf(sorts.get(i).getType_sors());
            switch (type_sort) {
                case NOIR:
                    nbPoint = nbPoint - 1;
                    break;
                case SOINS:
                    nbPoint = nbPoint + 2;
                    break;
                case PROTECTION:
                    nbPoint = nbPoint + 1;
                    break;
                case BLANCHE:
                    nbPoint = nbPoint + 2;
                    break;
                case INTERDIT:
                    nbPoint = nbPoint - 5;
                    break;
            }
        }
        return nbPoint;
    }

    @Override
    public Boolean exist(Integer id) {
        return repository.existsById(id);
    }
}
