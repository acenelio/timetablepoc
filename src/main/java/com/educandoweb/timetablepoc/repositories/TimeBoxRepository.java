package com.educandoweb.timetablepoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.timetablepoc.entities.TimeBox;

public interface TimeBoxRepository extends JpaRepository<TimeBox, Long> {

}
