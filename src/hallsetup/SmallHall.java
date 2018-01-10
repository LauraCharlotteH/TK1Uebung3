package hallsetup;

import hallsetup.Seat.Status;
import hallsetup.Seat.TypeOfSeat;

import com.sun.prism.Image;


public class SmallHall implements CinemaHall {

	Seat[][] seats;
	Movie movie;

	
	public SmallHall() {
		String description = "The Matrix is a 1999 science fiction action film written and directed by The Wachowski Brothers and starring Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano. It depicts a dystopian future in which reality as perceived by most humans is actually a simulated reality called the Matrix, created by sentient machines to subdue the human population, while their bodies' heat and electrical activity are used as an energy source. Computer programmer Neo learns this truth and is drawn into a rebellion against the machines, which involves other people who have been freed from the dream world.";
		this.movie = new Movie("Matrix", "15+", description);
		seats = new Seat[2][5]; //[row][seatNr]
		//fill all spots in array with empty normal seats
		for (int r = 0; r < 2; r++)
		{
		  for (int sN = 0; sN < 5; sN++)
		  {
		     seats[r][sN]= new Seat(r, sN, TypeOfSeat.NORMAL, Status.FREE);
		  }
		}
	}

	@Override
	public double reserveSeat(int row, int seatNr) {
		if (row<0 || seatNr<0 || row > 1 || seatNr > 4)return -2;//stay on arrangement
		if(seats[row][seatNr].getStatus()== Status.RESERVED) return -1; //already reserved
		if (seats[row][seatNr].getStatus() == Status.BROKEN)return 0; // broken seat
		seats[row][seatNr].setStatus(Status.RESERVED);
		return seats[row][seatNr].getPrice();
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
