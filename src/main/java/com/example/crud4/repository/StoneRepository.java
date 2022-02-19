package com.example.crud4.repository;

import com.example.crud4.entity.Stone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoneRepository extends JpaRepository<Stone, Long> {
}
