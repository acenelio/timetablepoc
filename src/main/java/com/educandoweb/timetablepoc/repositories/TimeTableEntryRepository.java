package com.educandoweb.timetablepoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.timetablepoc.entities.TimeTableEntry;

public interface TimeTableEntryRepository extends JpaRepository<TimeTableEntry, Long> {

}
