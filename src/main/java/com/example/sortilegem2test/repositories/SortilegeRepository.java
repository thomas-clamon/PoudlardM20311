package com.example.sortilegem2test.repositories;

import com.example.sortilegem2test.entities.SortilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortilegeRepository extends JpaRepository<SortilegeEntity, Integer> {
}