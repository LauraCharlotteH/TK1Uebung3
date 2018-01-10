package server;

public interface CinemaHall {


	//methods
	/**
	 * 
	 * @param row
	 * @param seatNr
	 * @return 1 if seat was successfully reserved
	 * 		0 if seat is broken and cannot be booked
	 * 		-1 if seat is booked already
	 * 		-2 if row/seatNr are not possible
	 */
	public int reserveSeat(int row, int seatNr);
	
	//getter (no setter as seats and movie will be hardcoded in the actuall halls)
	public Movie getMovie();
	public Seat[][] getSeats(); 

	
	
}
