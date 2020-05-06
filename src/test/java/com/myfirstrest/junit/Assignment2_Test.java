package com.myfirstrest.junit;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
public class Assignment2_Test {

	@Before
	public void init() {
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name/";
	}
	@WithTags({
	@WithTag("Get request: Assert"),
	@WithTag("Get request: Positive")
	})
	@Title("Get country details: Norway")
	@Test
	public void assignment2A() {
		SerenityRest.given().when().get("norway").then().log().all().assertThat().body("[0].capital", equalTo("Oslo"));

	}

}
