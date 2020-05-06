package com.myfirstrest.testbase;

import org.junit.Before;

import io.restassured.RestAssured;

public class TestBase {

	@Before
	public void init() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";
	}
}
