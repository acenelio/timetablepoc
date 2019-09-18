package com.educandoweb.timetablepoc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.timetablepoc.dto.IntervalDTO;
import com.educandoweb.timetablepoc.entities.TimeBox;
import com.educandoweb.timetablepoc.services.TimeTableService;

@RestController
@RequestMapping(value = "/timetable")
public class TimeTableResource {

	@Autowired
	private TimeTableService service;	
	
	@GetMapping(value = "/generate")
	public ResponseEntity<List<TimeBox>> generate(@RequestBody IntervalDTO dto) {
		List<TimeBox> list = service.generateTimeBoxes(dto);
		return ResponseEntity.ok().body(list);
	}
}
