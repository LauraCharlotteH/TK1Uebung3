package com.group20.ws;

import hallsetup.Seat;

import java.util.ArrayList;

import javax.jws.WebService;

import database.DataBase;

@WebService(endpointInterface = "com.group20.ws.ServiceEndpointInterface")
public class ServiceEndpointImpl implements ServiceEndpointInterface {

	DataBase database;
	
	

	public ServiceEndpointImpl() {
		this.database = new DataBase();
	}

	@Override
	public int reserveSeat(String movie, String day, String time, int row,
			int seatNr) {
		int dayToReserve = 0;
		int timeToReserve = 0;
		int hall = 0;
		switch (day) {
		case "monday":
			dayToReserve = 0;
			break;
		case "tuesday":
			dayToReserve = 1;
			break;
		case "wednesday":
			dayToReserve = 2;
			break;
		case "thursday":
			dayToReserve = 3;
			break;
		case "fridayday":
			dayToReserve = 4;
			break;
		case "saturday":
			dayToReserve = 5;
			break;
		case "sunday":
			dayToReserve = 6;
			break;
		}
		switch(time){
		case "12:00":
			timeToReserve = 0; break;
		case "16:00":
			timeToReserve = 1; break;
		case "20:00":
			timeToReserve = 2; break;
		}
		switch (movie){
		case "Hitchiker's Guide to the Galaxy":
			hall = 2; break;
		case "23":
			hall = 1; break;
		case "Matrix":
			hall = 0; break;
		}
		return database.getDays().get(dayToReserve).getTimes().get(timeToReserve).getHalls().get(hall).reserveSeat(row, seatNr);
	}

	@Override
	public String getMovies() {
		return "Hitchikers Guide to the galaxy, 23 and Matrix";

	}

	@Override
	public String getTimes() {
		return "12:00, 16:00 and 20:00";

	}

	@Override
	public String getSmallHallDescr() {
		return "our small hall fits ten people in two rows of normal seats";

	}

	@Override
	public String getMediumHallDescr() {
		return "our medium hall fits 24 people in four rows and the last row is fitted with our super comfy lounge chairs";

	}

	@Override
	public String getBigHallDescr() {
		return "our big hall fits 41 people in six rows and the last row is fitted with our super comfy lounge chairs";

	}

	@Override
	public DataBase getDataBase() {
		return database;

	}

	@Override
	public int reserveRandomSeats(String movie, String day, String time, int noOfSeats) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reserveSeats(String movie, String day, String time,
			ArrayList<String> listofSeats) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seat[][] getHall(String day, String time, String movie) {
		int dayToReserve = 0;
		int timeToReserve = 0;
		int hall = 0;
		switch (day) {
		case "monday":
			dayToReserve = 0;
			break;
		case "tuesday":
			dayToReserve = 1;
			break;
		case "wednesday":
			dayToReserve = 2;
			break;
		case "thursday":
			dayToReserve = 3;
			break;
		case "fridayday":
			dayToReserve = 4;
			break;
		case "saturday":
			dayToReserve = 5;
			break;
		case "sunday":
			dayToReserve = 6;
			break;
		}
		switch(time){
		case "12:00":
			timeToReserve = 0; break;
		case "16:00":
			timeToReserve = 1; break;
		case "20:00":
			timeToReserve = 2; break;
		}
		switch (movie){
		case "Hitchiker's Guide to the Galaxy":
			hall = 2; break;
		case "23":
			hall = 1; break;
		case "Matrix":
			hall = 0; break;
		}
		return database.getDays().get(dayToReserve).getTimes().get(timeToReserve).getHalls().get(hall).getSeats();
	}

}
