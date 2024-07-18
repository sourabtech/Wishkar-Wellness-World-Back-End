package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
