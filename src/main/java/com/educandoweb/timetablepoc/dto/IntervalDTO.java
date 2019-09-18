package com.educandoweb.timetablepoc.dto;

import java.io.Serializable;
import java.time.Instant;

public class IntervalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant start;
	private Instant end;
	private Long timeTableId;
	
	public IntervalDTO() {
	}

	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	public Instant getEnd() {
		return end;
	}

	public void setEnd(Instant end) {
		this.end = end;
	}

	public Long getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(Long timeTableId) {
		this.timeTableId = timeTableId;
	}
}
