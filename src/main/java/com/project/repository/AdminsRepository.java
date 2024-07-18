package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Admins;

public interface AdminsRepository extends JpaRepository<Admins, Long> {

}
