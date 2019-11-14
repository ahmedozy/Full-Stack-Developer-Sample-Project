/**
 * 
 */
package com.k15t.pat.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.k15t.pat.model.Address;
import com.k15t.pat.model.Participator;
import com.k15t.pat.registration.RegistrationController;

/**
 * @author NCTR
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
class TestControler {

	@Autowired
    private MockMvc mvc;
	
	private static Participator participator;
	private static Address address;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		participator = new Participator();
		participator.setName("Ahmed");
		participator.setEmail("ahmed@google.com");
		participator.setPassword("jjjj");
		address = new Address();
		address.setCountry("sd");
		address.setCity("khartoum");
		participator.setAddress(address);
	}

	/**
	 * Test method for {@link com.k15t.pat.registration.RegistrationController#registration(org.springframework.ui.Model)}.
	 * @throws Exception 
	 */
	@Test
	void testRegistrationModel() throws Exception {
		mvc.perform(get("/registration")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

	/**
	 * Test method for {@link com.k15t.pat.registration.RegistrationController#registration(com.k15t.pat.model.Participator, org.springframework.web.servlet.mvc.support.RedirectAttributes)}.
	 * @throws Exception 
	 */
	@Test
	void testRegistrationParticipatorRedirectAttributes() throws Exception {
		mvc.perform(post("/registration")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}
