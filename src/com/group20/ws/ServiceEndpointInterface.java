package com.group20.ws;

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
	
	@WebMethod int reserveRandomSeats(String movie, String day, String time, int noOfSeats);
	
	@WebMethod int reserveSeats(String movie, String day, String time, ArrayList<String> listofSeats);
	
	@WebMethod String getMovies();
	
	@WebMethod String getTimes();
	
	@WebMethod String getSmallHallDescr();
	
	@WebMethod String getMediumHallDescr();
	
	@WebMethod String getBigHallDescr();
	
	@WebMethod DataBase getDataBase();

}
