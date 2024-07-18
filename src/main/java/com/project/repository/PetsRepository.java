package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Pets;

public interface PetsRepository extends JpaRepository<Pets, Long> {

}
