package com.group20.ws;

import hallsetup.Seat;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import database.*;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface ServiceEndpointInterface {
	
	//all methods available for the client:
	
	@WebMethod int reserveSeat(String movie, String day, String time, int row, int seatNr);
	
	@WebMethod Seat[][] getHall(String day, String time, String movie);
	
	@WebMethod DataBase getDataBase();
	
	@WebMethod int addReservation(ArrayList<Seat> seats);
	
	

}
