package com.myfirstrest.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class ExtractandUpdate {
	
	
	@Before
	public void init() {
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/";
	}

	@Test
	public void extractEmployee() {
		//String p1 = "findAll{it.data.employee_name=='";
		String p1 ="findAll{it.languages=='";
		String p2 = "'}.name";
		String lang = "en";
		
		//HashMap<String, Object> emp = SerenityRest.rest().given().when().get("employees").then().log().all().extract().path(p1+empname+p2);
		//SerenityRest.given().when().get("employees").then().log().body();
		
		//SerenityRest.given().when().get().then().body("findAll{it.languages}", hasItem("en")).log().all();
		//System.out.println(emp);
		//Response respo = SerenityRest.rest().given().when().get().then().log().all().extract().path(p1+lang+p2);
		ResponseBodyExtractionOptions respo = SerenityRest.given().when().get().then().extract().body();
		 //ArrayList<Map<String,?>> jsonAsArrayList = from(respo.asString()).get("");
		System.out.println("English countries" +respo.asString());
	}

}
