package com.educandoweb.timetablepoc.entities.interfaces;

import java.io.Serializable;
import java.time.DayOfWeek;

public interface TimeEntry extends Serializable, Comparable<TimeEntry> {

	DayOfWeek getDay();
	Long getStartMillisecond();
	Long getEndMillisecond();

	default void setStartMillisecond(Long startMillisecond) {
		if (startMillisecond >= getEndMillisecond()) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		setStartMillisecond(startMillisecond);
	}

	default void setEndMillisecond(Long endMillisecond) {
		if (getStartMillisecond() >= endMillisecond) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		setEndMillisecond(endMillisecond);
	}
	
	default Long getStartSecond() {
		return getStartMillisecond() / 1000L;
	}

	default Long getEndSecond() {
		return getEndMillisecond() / 1000L;
	}
	
	default Long getStartHour() {
		return getStartMillisecond() / 3600000L;
	}
	
	default Long getStartMinute() {
		return getStartMillisecond() % 3600000L;
	}

	default Long getEndHour() {
		return getEndMillisecond() / 3600000L;
	}
	
	default Long getEndMinute() {
		return getEndMillisecond() % 3600000L;
	}

	default void setStart(Long startHour, Long startMinute) {
		Long startMillisecond = startHour * 3600000L + startMinute * 60000L;
		setStartMillisecond(startMillisecond);
	}

	default void setEnd(Long endHour, Long endMinute) {
		Long endMillisecond = endHour * 3600000L + endMinute * 60000L;
		setEndMillisecond(endMillisecond);
	}
	
	default boolean conflicts(TimeEntry other) {
		if (getDay() != other.getDay()) {
			return false;
		}
		if (getEndMillisecond() <= other.getStartMillisecond() || getStartMillisecond() >= other.getEndMillisecond()) {
			return false;
		}
		return true;
	}
	
	@Override
	default int compareTo(TimeEntry other) {
		if (getDay().compareTo(other.getDay()) == 0) {
			return getStartMillisecond().compareTo(other.getStartMillisecond());
		}
		return getDay().compareTo(other.getDay());
	}
}
