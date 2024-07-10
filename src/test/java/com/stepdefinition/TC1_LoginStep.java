package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.datas.GlobalDatas;
import com.endpoints.Endpoints;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass{
	static GlobalDatas globalDatas = new GlobalDatas();
	Response response;
	

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");

	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
	}
	
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String type) {
		response = addReqType(type, Endpoints.LOGIN);
		int statusCode = getStatusCode(response);
		globalDatas.setStatusCode(statusCode);
		
	}
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("Verify first name", expFirstName, first_name);
		
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogToken(logtoken);
	}
}
