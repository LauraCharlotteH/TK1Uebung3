package database;
import hallsetup.*;

import java.util.*;

public class Time {

	String time;
	List<CinemaHall> halls;
	
	public Time(String time) {
		this.time = time;
		this.halls = new ArrayList<CinemaHall>();
		halls.add(new SmallHall());
		halls.add(new MediumHall());
		halls.add(new BigHall());
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<CinemaHall> getHalls() {
		return halls;
	}	
	
}
