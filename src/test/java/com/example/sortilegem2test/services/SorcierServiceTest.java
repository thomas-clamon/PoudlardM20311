package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import com.example.sortilegem2test.entities.SortilegeEntity;
import com.example.sortilegem2test.repositories.SorcierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierServiceTest {

    @Autowired
    private SorcierRepository repository;

    private SorcierService sorcierService = new SorcierService();

    @Test
     void test_transform_to_dto(){

        // arrange c'est le script + la recuperation de l'entité
        SorcierEntity harry = repository.findById(1).get();

        //access
        SorcierDto dto = sorcierService.toDto(harry);

        // assert
        assertEquals("HARRY POTTER", dto.getDisplay_name());
        assertEquals(21, dto.getAge());
        assertEquals("Grynfondor", dto.getMaison());


    }

    @Test
    void toDto() {
    }

    @Test
    void nbPoint() {
        // Arange
        SorcierEntity sorcier = new SorcierEntity();
        List<SortilegeEntity> sors = new ArrayList<SortilegeEntity>();

        SortilegeEntity sort1 = new SortilegeEntity();
        sort1.setType_sors("INTERDIT");

        SortilegeEntity sort2 = new SortilegeEntity();
        sort2.setType_sors("SOINS");

        sors.add(sort1);
        sors.add(sort2);

        // j'ajoute la liste au sorcier
        sorcier.setList_sortilege(sors);

        // access
        Integer nbPoint = sorcierService.nbPoint(sorcier);

        assertEquals(nbPoint, -3 );

    }
}