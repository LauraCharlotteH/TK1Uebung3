package database;

import java.util.ArrayList;

public class Reservation {

	int id;
	ArrayList<String> seats;
	
	public Reservation(int id, ArrayList<String> seats) {
		this.id = id;
		this.seats = seats;
	}
	
	
}
