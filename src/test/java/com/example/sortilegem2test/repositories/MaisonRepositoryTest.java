package com.example.sortilegem2test.repositories;

import com.example.sortilegem2test.entities.MaisonEntity;
import com.example.sortilegem2test.entities.SorcierEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MaisonRepositoryTest {

    @Autowired
    private MaisonRepository repository;

    @Test
    private void should_2_house_with_student(){

        // arange par le script

        // access on recupere la liste des maison
        List<MaisonEntity> list = repository.findAll();

        // assert
        assertEquals(2, list.size()); // Deux maison grynfodor et serpentar

        // on verifie que la premiere est bien grynfondor
        MaisonEntity maison = list.get(0);
        assertEquals("Grynfondor", maison.getNom());

        // on verifie qu'il y bien 1 Sorcier dans la maison
        assertEquals(1, maison.getList_sorcier().size());

        // on verfie que le sorcier est bien Harry
        SorcierEntity harry = maison.getList_sorcier().get(0);
        assertEquals("Harry", harry.getPrenom());


    }

}