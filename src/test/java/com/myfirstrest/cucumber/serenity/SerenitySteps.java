package com.myfirstrest.cucumber.serenity;

import com.myfirstrest.model.Customer;
import com.myfirstrest.utils.ReusableSpecs;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SerenitySteps {
	
	
	@Step("Creating customer with Firstname:{0}, LastName:{1}, UserName:{2}, Email:{4}, Password:{3} ")
	public ValidatableResponse createCustomer(String FirstName, String LastName, String UserName, String Password, String Email) {
		
		Customer cus = new Customer();
		cus.setFirstName(FirstName);
		cus.setLastName(LastName);
		cus.setEmail(Email);
		cus.setPassword(Password);
		cus.setUserName(UserName);
		
		return SerenityRest.given().spec(ReusableSpecs.getGenericReqSpec()).when().body(cus).post().then();
	}

}
