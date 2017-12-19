package server;

import com.sun.prism.Image;


public class SmallHall implements CinemaHall {

	Seat[][] seats;
	Movie movie;

	
	public SmallHall() {
		
		this.seats = seats;
		this.movie = new Movie("Matrix", "15+", "The Matrix is a 1999 science fiction action film written and directed by The Wachowski Brothers and starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano. It depicts a dystopian future in which reality as perceived by most humans is actually a simulated reality called the Matrix, created by sentient machines to subdue the human population, while their bodies' heat and electrical activity are used as an energy source. Computer programmer Neo learns this truth and is drawn into a rebellion against the machines, which involves other people who have been freed from the dream world.", new Image("src/resources/matrix.jpg"));
		
	}

	@Override
	public boolean reserveSeat(int row, int seatNr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}



	@Override
	public Seat[][] getSeats() {
		return seats;
	}


}
