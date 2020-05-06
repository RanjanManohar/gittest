package com.myfirstrest.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.myfirstrest.cucumber.serenity.SerenitySteps;
import com.myfirstrest.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent(threads="2x")
//to run parallelly
@UseTestDataFrom("testdata/customerData.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateCustomerDataDriven extends TestBase{
	
	//Generated data using mockaroo.com
	
	@Steps
	SerenitySteps step;
	
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	
	public String getFirstName() {
		return this.FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName=FirstName;
	}
	
	public String getLastName() {
		return this.LastName;
	}
	public void setLastName(String LastName) {
		this.LastName=LastName;
	}
	public String getUserName() {
		return this.UserName;
	}
	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	public String getPassword() {
		return this.Password;
	}
	public void setPassword(String Password) {
		this.Password=Password;
	}
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String Email) {
		this.Email=Email;
	}
	
	
	@Title("Create Multiple customers")
	@Test
	public void createMultipleCustomers() {
		
		step.createCustomer(FirstName, LastName, UserName, Password, Email).statusCode(201);
		
	}

}
