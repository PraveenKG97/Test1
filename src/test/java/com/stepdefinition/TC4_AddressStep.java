package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.address.AddressPayload;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {

	AddressPayload addressPayload = new AddressPayload();
	Response response ;
//AddAddress
	
	@Given("User add header and bearer authorization for accessing Addaddress endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddaddressEndpoints() {
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
	  AddUserAddress_Input_Pojo payload = addressPayload.addAddressPayload(first_name, last_name, mobile,  apartment,  TC1_LoginStep.globalDatas.getStateId(),  TC1_LoginStep.globalDatas.getCityId(),  101,  zipcode,  address,  address_type);
	  addReqBody(payload);
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		response = addReqType(type, Endpoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
		
	}
	@Then("User should verify the addUserAddress response message matches {string}")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatches(String expectedValue) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actualValue = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address added successfully", expectedValue, actualValue);
		
		Integer address_id = addUserAddress_Output_Pojo.getAddress_id();
		String addressid = address_id.toString();
		TC1_LoginStep.globalDatas.setAddressId(addressid);
		
	}
	
//UpdateAddress	

	@Given("User add header and bearer authorization for accessing Updateaddress endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingUpdateaddressEndpoints() {
List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}

	@When("User add request body to Update address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddRequestBodyToUpdateAddressAnd(String address_id, String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
	    UpdateUserAddress_Input_Pojo updateUserAddressPayload = addressPayload.updateUserAddressPayload(TC1_LoginStep.globalDatas.getAddressId(), first_name, last_name, mobile,  apartment,  TC1_LoginStep.globalDatas.getStateId(),  TC1_LoginStep.globalDatas.getCityId(),  101,  zipcode,  address,  address_type);
	    addReqBody(updateUserAddressPayload);
	    
	}
	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {
		response = addReqType(type, Endpoints.UPDATEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User should verify the updateUserAddress response message matches {string}")
	public void userShouldVerifyTheUpdateUserAddressResponseMessageMatches(String expectedValue) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actualValue = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address updated successfully", expectedValue, actualValue);
	}

//GetAddress
	 
	@Given("User add header and bearer authorization for accessing Getaddress endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetaddressEndpoints() {
	List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogToken());
		
		lstheader.add(h1);
		lstheader.add(h2);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}
	@When("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		response = addReqType(type, Endpoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User should verify the getUserAddress response message matches {string}")
	public void userShouldVerifyTheGetUserAddressResponseMessageMatches(String expectedValue) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actualValue = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify the Get Address message", expectedValue, actualValue);
	}

//DeleteAddress
	
	@Given("User add header and bearer authorization for accessing Deleteaddress endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingDeleteaddressEndpoints() {
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
		
	}

	@When("User add request body to delete address {string}")
	public void userAddRequestBodyToDeleteAddress(String address_id) {
	   DeleteUserAddress_Input_Pojo deleteUserAddress = addressPayload.deleteUserAddress(TC1_LoginStep.globalDatas.getAddressId());
	   addReqBody(deleteUserAddress);
	}
	@When("User send {string} request for deleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String type) {
		response = addReqType(type, Endpoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User should verify the deleteAddress response message matches {string}")
	public void userShouldVerifyTheDeleteAddressResponseMessageMatches(String expectedValue) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actualValue = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address Deleted Successfully", expectedValue, actualValue);
	}



}
