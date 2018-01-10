package server;

import server.Seat.Status;
import server.Seat.TypeOfSeat;

public class BigHall implements CinemaHall {

	Seat[][] seats;
	Movie movie;

	public BigHall() {
		String description = "The Hitchhiker's Guide to the Galaxy is a 2005 British-American science fiction comedy film directed by Garth Jennings, based upon previous works in the media franchise of the same name, created by Douglas Adams. It stars Martin Freeman, Sam Rockwell, Mos Def, Zooey Deschanel and the voices of Stephen Fry and Alan Rickman. Adams, who co-wrote the screenplay with Karey Kirkpatrick, died in 2001, before production began; the film is dedicated to him. The film grossed over $100 million worldwide.";
		this.movie = new Movie("The Hitchiker's Guide to the Galaxy", "PG", description);
		seats = new Seat[6][7]; // [row][seatNr]
		// fill all spots the first rows with empty normal seats
		for (int r = 0; r < 5; r++) {
			for (int sN = 0; sN < 7; sN++) {
				seats[r][sN] = new Seat(r, sN, TypeOfSeat.NORMAL, Status.FREE);
			}
		}
		// fill last row with lounge seats
		for (int sN = 0; sN < 7; sN++) {
			seats[5][sN] = new Seat(5, sN, TypeOfSeat.LOUNGE, Status.FREE);
		}
	}

	@Override
	public int reserveSeat(int row, int seatNr) {
		if (row < 0 || seatNr < 0 || row > 5 || seatNr > 6)
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
