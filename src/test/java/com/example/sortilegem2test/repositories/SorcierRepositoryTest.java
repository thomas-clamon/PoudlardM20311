package com.example.sortilegem2test.repositories;

import com.example.sortilegem2test.entities.SorcierEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SorcierRepositoryTest {

    @Autowired
    private SorcierRepository repository;

    @Test
    public void should_harry_in_db(){

        // Arrange est deja faite avec le script data.sql

        // access on recupere le premier sorcier
        List<SorcierEntity> list = repository.findAll();

        // assertion
        assertEquals(1, list.size());

        SorcierEntity harry = list.get(0);

        assertEquals("Harry", harry.getPrenom());


    }

}