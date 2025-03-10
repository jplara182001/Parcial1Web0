package com.example.api.repositories;

import com.example.api.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity, UUID> {
}
