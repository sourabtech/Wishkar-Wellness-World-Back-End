package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Appointments;

public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

}
