package com.k15t.pat.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.k15t.pat.model.Participator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/registration")
@Component
public class RegistrationResource {

	@Autowired
	private ParticipatorRepository participatorRepo;
    // Extend the current resource to receive and store the data in memory.
    // Return a success information to the user including the entered information.
    // In case of the address split the information into a better format/structure
    // for better handling later on.
    public Response save(Participator participator) {
    	try {
    		participatorRepo.save(participator);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return Response.serverError().build();
    	}
        return Response.ok().build();
    }

}
