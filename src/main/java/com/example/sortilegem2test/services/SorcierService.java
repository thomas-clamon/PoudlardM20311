package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class SorcierService implements ISorcierService{
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
}
