package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.DayCareBookings;

public interface DayCareBookingsRepository extends JpaRepository<DayCareBookings, Long> {

}
