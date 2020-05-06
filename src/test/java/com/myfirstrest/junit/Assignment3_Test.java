package com.myfirstrest.junit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.myfirstrest.cucumber.serenity.SerenitySteps;
import com.myfirstrest.testbase.TestBase;
import com.myfirstrest.utils.RandomGen;
import com.myfirstrest.utils.ReusableSpecs;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment3_Test extends TestBase {

	@Steps
	SerenitySteps step;

	static String FirstName = "Ranjan" + RandomGen.GetRandomNo();
	static String LastName = "Manohar" + RandomGen.GetRandomNo();
	static String UserName = "Manohran" + RandomGen.GetRandomNo();
	static String Password = "Bigbang" + RandomGen.GetRandomNo();
	static String Email = RandomGen.GetRandomNo() + "shc73@gmail.com";
	@WithTags({
		@WithTag("Postfeature:Assert"),
		@WithTag("Postfeature:Positive")
		})
	@Title("Create Customer")
	@Test
	public void customerRegestrationA() {

		System.out.println(FirstName + LastName + UserName + Password + Email);

		step.createCustomer(FirstName, LastName, UserName, Password, Email).log().all().statusCode(201)
				.spec(ReusableSpecs.getGenericRespSpec()).assertThat().body("SuccessCode", equalTo("OPERATION_SUCCESS"),
						"Message", equalTo("Operation completed successfully"));
	}
	@WithTags({
		@WithTag("Postfeature:Assert"),
		@WithTag("Postfeature:Negative")
		})

	@Title("Create Customer with same username")
	@Test
	public void customerRegestrationB() {
		step.createCustomer(FirstName, LastName, UserName, Password, Email).log().all().statusCode(200).assertThat()
				.body(containsString("FAULT_USER_ALREADY_EXISTS"));
	}
}
