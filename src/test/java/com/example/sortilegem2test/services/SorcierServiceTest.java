package com.example.sortilegem2test.services;

import com.example.sortilegem2test.dto.SorcierDto;
import com.example.sortilegem2test.entities.SorcierEntity;
import com.example.sortilegem2test.repositories.SorcierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierServiceTest {

    @Autowired
    private SorcierRepository repository;

    private SorcierService sorcierService = new SorcierService();

    @Test
    private void test_transform_to_dto(){

        // arrange c'est le script + la recuperation de l'entité
        SorcierEntity harry = repository.findById(1).get();

        //access
        SorcierDto dto = sorcierService.toDto(harry);

        // assert
        assertEquals("HARRY POTTER", dto.getDisplay_name());
        assertEquals(22, dto.getAge());
        assertEquals("Grynfondor", dto.getMaison());


    }

}