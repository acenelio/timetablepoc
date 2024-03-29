package com.educandoweb.timetablepoc.config;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.timetablepoc.entities.TimeTable;
import com.educandoweb.timetablepoc.entities.TimeTableEntry;
import com.educandoweb.timetablepoc.repositories.TimeTableEntryRepository;
import com.educandoweb.timetablepoc.repositories.TimeTableRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private TimeTableEntryRepository timeTableEntryRepository;
	
	@Autowired
	private TimeTableRepository timeTableRepository;

	@Override
	public void run(String... args) throws Exception {
		
		TimeTable t1 = new TimeTable(null, "Horários 2019-2");

		TimeTableEntry e1 = new TimeTableEntry(null, DayOfWeek.MONDAY, 18L, 45L, 19L, 30L, t1);
		TimeTableEntry e2 = new TimeTableEntry(null, DayOfWeek.MONDAY, 19L, 30L, 20L, 15L, t1);
		TimeTableEntry e3 = new TimeTableEntry(null, DayOfWeek.TUESDAY, 18L, 45L, 19L, 30L, t1);
		TimeTableEntry e4 = new TimeTableEntry(null, DayOfWeek.TUESDAY, 19L, 30L, 20L, 15L, t1);
		TimeTableEntry e5 = new TimeTableEntry(null, DayOfWeek.TUESDAY, 20L, 15L, 21L, 00L, t1);

		timeTableRepository.save(t1);
		timeTableEntryRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		
		//TimeBox tb1 = new TimeBox(null, DayOfWeek.MONDAY, 18L, 45L, 19L, 30L, t1);
		//timeBoxRepository.save(tb1);
		
		LocalDateTime dt1 = LocalDateTime.now(ZoneId.systemDefault());
		
		System.out.println("DADOS=====================");
		System.out.println(dt1);
		
		Instant i1 = dt1.atZone(ZoneId.systemDefault()).toInstant();
		System.out.println(i1);
		System.out.println(dt1.getDayOfWeek());
		
		LocalDate d1 = dt1.toLocalDate();
		System.out.println(d1.getDayOfWeek());
	}
}
