package com.myfirstrest.utils;

import java.util.concurrent.TimeUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class ReusableSpecs {
	
	public static RequestSpecBuilder reqBuild = new RequestSpecBuilder();
	public static RequestSpecification reqspec;
	public static ResponseSpecBuilder resBuild = new ResponseSpecBuilder();
	public static ResponseSpecification respec;
	
	public static RequestSpecification getGenericReqSpec() {
		reqBuild.setContentType(ContentType.JSON);
		reqspec=reqBuild.build();
		return reqspec;
	}
	
	public static ResponseSpecification getGenericRespSpec() {
		resBuild.expectHeader("Content-Type","application/json");
		resBuild.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		respec=resBuild.build();
		return respec;
	}

}
