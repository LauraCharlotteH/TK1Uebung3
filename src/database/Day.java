package database;

import java.util.ArrayList;
import java.util.List;

public class Day {

	String weekday;
	List <Time> times;
	
	public Day(String day) {
		this.weekday = day;
		this.times = new ArrayList<Time>();
		times.add(new Time("12:00"));
		times.add(new Time("16:00"));
		times.add(new Time("20:00"));
	}
	
	public String getDay() {
		return weekday;
	}
	public void setDay(String day) {
		this.weekday = day;
	}
	public List<Time> getTimes() {
		return times;
	}	
	
}
