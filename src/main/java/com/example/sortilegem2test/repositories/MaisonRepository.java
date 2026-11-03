package com.example.sortilegem2test.repositories;

import com.example.sortilegem2test.entities.MaisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonRepository extends JpaRepository<MaisonEntity, Integer> {
}
