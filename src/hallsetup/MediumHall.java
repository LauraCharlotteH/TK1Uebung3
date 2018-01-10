package hallsetup;

import hallsetup.Seat.Status;
import hallsetup.Seat.TypeOfSeat;

public class MediumHall implements CinemaHall {

	Seat[][] seats;
	Movie movie;

	public MediumHall() {
		String description = "is a 2007 American psychological thriller film written by Fernley Phillips and directed by Joel Schumacher. Jim Carrey stars as a man who becomes obsessed with the 23 enigma once he reads about it in a strange book that seemingly mirrors his own life. The film was released in the United States on February 23, 2007. This is the second film to pair Schumacher and Carrey, the first being Batman Forever. The film grossed $77.6 million and has an approval rating of 8% on Rotten Tomatoes. Carrey was nominated for a Golden Raspberry Award for Worst Actor for his performance in the film, but he lost to Eddie Murphy for Norbit.";
		this.movie = new Movie("The Number 23", "R", description);
		seats = new Seat[4][6]; // [row][seatNr]
		// fill all spots the first rows with empty normal seats
		for (int r = 0; r < 3; r++) {
			for (int sN = 0; sN < 6; sN++) {
				seats[r][sN] = new Seat(r, sN, TypeOfSeat.NORMAL, Status.FREE);
			}
		}
		// fill last row with lounge seats
		for (int sN = 0; sN < 6; sN++) {
			seats[3][sN] = new Seat(3, sN, TypeOfSeat.LOUNGE, Status.FREE);
		}
		// make sure to include the broken seat that cannot be used
		seats[3][5].setStatus(Status.BROKEN);
	}

	@Override
	public int reserveSeat(int row, int seatNr) {
		if (row < 0 || seatNr < 0 || row > 3 || seatNr > 5)
			return -2; // stay within seat arrangement
		if (seats[row][seatNr].getStatus() == Status.BROKEN)
			return 0; // broken seat
		if (seats[row][seatNr].getStatus() == Status.RESERVED)
			return -1; // already reserved
		seats[row][seatNr].setStatus(Status.RESERVED);
		return 1;
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
