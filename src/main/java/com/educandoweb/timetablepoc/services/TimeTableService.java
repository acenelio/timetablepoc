package com.educandoweb.timetablepoc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.timetablepoc.dto.IntervalDTO;
import com.educandoweb.timetablepoc.entities.TimeBox;
import com.educandoweb.timetablepoc.entities.TimeTable;
import com.educandoweb.timetablepoc.repositories.TimeTableRepository;

@Service
public class TimeTableService {

	@Autowired
	private TimeTableRepository repository;
	
	@Transactional(readOnly = true)
	public List<TimeBox> generateTimeBoxes(IntervalDTO dto) {
		
		TimeTable timeTable = repository.getOne(dto.getTimeTableId());

		return timeTable.getEntries().stream()
				.filter(e -> e.getStartSecond() >= dto.getStart().getEpochSecond() && e.getEndSecond() <= dto.getEnd().getEpochSecond())
				.map(e -> e.toTimeBox())
				.sorted()
				.collect(Collectors.toList());	
	}	
}
