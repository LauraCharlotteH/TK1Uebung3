package database;

import hallsetup.Seat;

import java.util.ArrayList;

public class Reservation {

	int id;
	ArrayList<Seat> seats;
	
	public Reservation(int id, ArrayList<Seat> seats) {
		this.id = id;
		this.seats = seats;
	}
	
	
}
