package server;

public interface CinemaHall {


	//methods
	public boolean reserveSeat(int row, int seatNr);
	
	//getter (no setter as seats and movie will be hardcoded in the actuall halls)
	public Movie getMovie();
	public Seat[][] getSeats(); 

	
	
}
