package com.educandoweb.timetablepoc.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.timetablepoc.dto.TimesDTO;
import com.educandoweb.timetablepoc.services.TimeTableService;

@RestController
@RequestMapping(value = "/timetable")
public class TimeTableResource {

	@Autowired
	private TimeTableService service;	
	
	@GetMapping(value = "/{timeTableId}/timeboxes")
	public ResponseEntity<TimesDTO> timeboxes(@RequestParam(value="date") String date, @PathVariable Long timeTableId) {
		LocalDate d = LocalDate.parse(date);
		TimesDTO times = service.times(timeTableId, d);
		return ResponseEntity.ok().body(times);
	}

	@GetMapping(value = "/{timeTableId}/timeboxesrange")
	public ResponseEntity<List<TimesDTO>> timeboxesrange(
			@RequestParam(value="startDate") String startDate, 
			@RequestParam(value="endDate") String endDate, 
			@PathVariable Long timeTableId) {
		LocalDate d1 = LocalDate.parse(startDate);
		LocalDate d2 = LocalDate.parse(endDate);
		List<TimesDTO> list = service.times(timeTableId, d1, d2);
		return ResponseEntity.ok().body(list);
	}
}
