package com.example.crud4.repository;

import com.example.crud4.entity.Gauntlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GauntletRepository extends JpaRepository<Gauntlet, Long> {
}
