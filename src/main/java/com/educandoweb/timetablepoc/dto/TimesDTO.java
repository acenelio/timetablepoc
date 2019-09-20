package com.educandoweb.timetablepoc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private List<TimeBoxDTO> times = new ArrayList<>();
	
	public TimesDTO() {
	}

	public TimesDTO(LocalDate date) {
		super();
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<TimeBoxDTO> getTimes() {
		return times;
	}

	public void addTimeBox(TimeBoxDTO timeBoxDTO) {
		times.add(timeBoxDTO);
	}
	
	public void addAllTimeBoxes(List<TimeBoxDTO> list) {
		times.addAll(list);
	}
}
