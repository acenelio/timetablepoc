package com.educandoweb.timetablepoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.timetablepoc.entities.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

}
