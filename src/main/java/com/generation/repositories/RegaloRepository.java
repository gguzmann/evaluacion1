package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Regalo;

@Repository
public interface RegaloRepository extends JpaRepository<Regalo, Long>{

}
