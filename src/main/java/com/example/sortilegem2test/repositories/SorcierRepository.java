package com.example.sortilegem2test.repositories;

import com.example.sortilegem2test.entities.SorcierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SorcierRepository extends JpaRepository <SorcierEntity, Integer> {
}
