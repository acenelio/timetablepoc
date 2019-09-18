package com.educandoweb.timetablepoc.entities;

import java.time.DayOfWeek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.educandoweb.timetablepoc.entities.interfaces.TimeEntry;

@Entity
@Table(name = "tb_time_box")
public class TimeBox implements TimeEntry {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private DayOfWeek day;
	private Long startMillisecond;
	private Long endMillisecond;

	@ManyToOne
	@JoinColumn(name = "time_table_id")
	private TimeTable timeTable;
	
	public TimeBox() {
	}
	
	public TimeBox(Long id, DayOfWeek day, Long startMillisecond, Long endMillisecond, TimeTable timeTable) {
		if (startMillisecond >= endMillisecond) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		this.id = id;
		this.day = day;
		this.startMillisecond = startMillisecond;
		this.endMillisecond = endMillisecond;
		this.timeTable = timeTable;
	}

	public TimeBox(Long id, DayOfWeek day, Long startHour, Long startMinute, Long endHour, Long endMinute, TimeTable timeTable) {
		Long startMillisecond = startHour * 3600000L + startMinute * 60000L;
		Long endMillisecond = endHour * 3600000L + endMinute * 60000L;
		if (startMillisecond >= endMillisecond) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		this.id = id;
		this.day = day;
		this.startMillisecond = startMillisecond;
		this.endMillisecond = endMillisecond;
		this.timeTable = timeTable;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	@Override
	public Long getStartMillisecond() {
		return startMillisecond;
	}

	@Override
	public Long getEndMillisecond() {
		return endMillisecond;
	}

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((endMillisecond == null) ? 0 : endMillisecond.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startMillisecond == null) ? 0 : startMillisecond.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeBox other = (TimeBox) obj;
		if (day != other.day)
			return false;
		if (endMillisecond == null) {
			if (other.endMillisecond != null)
				return false;
		} else if (!endMillisecond.equals(other.endMillisecond))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startMillisecond == null) {
			if (other.startMillisecond != null)
				return false;
		} else if (!startMillisecond.equals(other.startMillisecond))
			return false;
		return true;
	}	
}
