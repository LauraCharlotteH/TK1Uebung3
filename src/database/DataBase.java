package database;

import java.util.*;

public class DataBase {

	ArrayList <Day> days;
	Reservations res;


	public DataBase() {

		this.res = new Reservations();
		this.days = new ArrayList<Day>();
		days.add(new Day("monday"));
		days.add(new Day("tuesday"));
		days.add(new Day("wednesday"));
		days.add(new Day("thursday"));
		days.add(new Day("friday"));
		days.add(new Day("saturday"));
		days.add(new Day("sunday"));
		
	}


	public List<Day> getDays() {
		return days;
	}

	public Reservations getRes() {
		return res;
	}

	
}
