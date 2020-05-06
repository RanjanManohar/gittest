package com.myfirstrest.junit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class Assignment1_Test {

	@Before
	public void init() {
		// SerenityRest.setDefaultBasePath("https://www.google.com/");
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name/";
	}
	@WithTag("Get request: Positive")
	@Title("Get country details: INDIA")
	@Test
	public void assignment1A() {
		SerenityRest.given().when().get("INDIA").then().log().all().assertThat()
				.body(containsString("Republic of India"));

	}
	@WithTag("Get request: Negative")
	@Title("Get country details: xyz")
	@Test
	public void assignment1B() {
		SerenityRest.given().when().get("xyz").then().log().all().assertThat().body("status", equalTo(404), "message",
				equalTo("Not Found"));
	}

}
