package endpoint;
import javax.xml.ws.Endpoint;

import ws.ServiceEndpointImpl;

//Endpoint publisher
public class EndpointPublisher{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8090/ws/tickets", new ServiceEndpointImpl());
    }

}

