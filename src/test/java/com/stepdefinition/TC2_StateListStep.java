package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.DatumStateList;
import com.pojo.address.StateList_output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClass{

	Response response;

	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
		addHeader("accept", "application/json");
	}
	
	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
		response = addReqType(type, Endpoints.STATE);
		
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	
	@Then("User should verify the stateList response message matches {string} and saved state id")
	public void userShouldVerifyTheStateListResponseMessageMatchesAndSavedStateId(String expectedValue) {
		
		StateList_output_Pojo stateList_output_Pojo = response.as(StateList_output_Pojo.class);
		DatumStateList datumStateList = stateList_output_Pojo.getData().get(34);
		String actualValue = datumStateList.getName();
		Assert.assertEquals("Verify state TamilNadu", expectedValue, actualValue);
		
		TC1_LoginStep.globalDatas.setStateId(34);
		
	}



}
