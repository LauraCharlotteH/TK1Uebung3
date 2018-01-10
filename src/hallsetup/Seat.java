package hallsetup;

public class Seat {
public enum TypeOfSeat {NORMAL, LOUNGE}
public enum Status{FREE, RESERVED, BROKEN}

private int row;
private int seatNr;
private TypeOfSeat type;
private Status status;


public Seat(){
	this.row = -1;
	this.seatNr = -1;
	this.type = null;
	this.status = null;
}

public Seat(int row, int seatNr, TypeOfSeat type, Status status) {
	this.row = row;
	this.seatNr = seatNr;
	this.type = type;
	this.status = status;
}

public double getPrice(){
	double price = 0;
	switch(type){
	case NORMAL: price = 8.50; break;
	case LOUNGE: price = 10.0; break;
	default: price = 8.50; break;
	}
	return price;
}

//getter and setter
public int getRow() {
	return row;
}
public void setRow(int row) {
	this.row = row;
}
public int getSeatNr() {
	return seatNr;
}
public void setSeatNr(int seatNr) {
	this.seatNr = seatNr;
}
public TypeOfSeat getType() {
	return type;
}
public void setType(TypeOfSeat type) {
	this.type = type;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
}
