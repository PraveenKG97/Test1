package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.address.AddressPayload;
import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.CityList_Output_Pojo;
import com.pojo.address.DatumCityList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClass{
	
	AddressPayload addressPayload = new AddressPayload();
	Response response ; 
	

	@Given("User add headers for to get CityList")
	public void userAddHeadersForToGetCityList() {
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
			
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}
	@When("User add request body state id for get city list")
	public void userAddRequestBodyStateIdForGetCityList() {
	   CityList_Input_Pojo cityList = addressPayload.getCityList("35");
	   addReqBody(cityList);
	}
	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String type) {
		response = addReqType(type, Endpoints.CITY);
		
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User should verify the cityList response message matches {string} and saved city id")
	public void userShouldVerifyTheCityListResponseMessageMatchesAndSavedCityId(String expectedValue) {
	    
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		DatumCityList datumCityList = cityList_Output_Pojo.getData().get(632);
		String actualValue = datumCityList.getName();
		Assert.assertEquals("Verify city Salem", expectedValue, actualValue);
	
		TC1_LoginStep.globalDatas.setCityId(35);
	}

}
