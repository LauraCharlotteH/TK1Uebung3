package database;

import hallsetup.Seat;

import java.util.ArrayList;

public class Reservations {

	ArrayList<Reservation> reservations;
	
	public Reservations(){
		this.reservations = new ArrayList<Reservation>();
	}
	
	/**
	 * 
	 * @param res reservaton to be added
	 * @return true if succesfull false if ID is already in list
	 */
	public int addReservation(ArrayList<String> seats){
		int id = reservations.size();
		reservations.add(new Reservation(id, seats));
		return id;
	}
	
}
