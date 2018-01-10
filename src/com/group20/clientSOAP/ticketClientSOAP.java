package com.group20.clientSOAP;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.group20.ws.*;

import database.DataBase;


public class ticketClientSOAP {
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8090/ws/tickets?wsdl");

	        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
	        QName qname = new QName("http://ws.group20.com/", "ServiceEndpointImplService");

	        Service service = Service.create(url, qname);

	        ServiceEndpointInterface sei = service.getPort(ServiceEndpointInterface.class);

	        System.out.println(sei.getBigHallDescr());

	    }
}
