package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.profile.ProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass{

	Response response;

	@Given("User add header and bearer authorization for accessing change profile pic endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingChangeProfilePicEndpoints() {
		List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.globalDatas.getLogToken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		
		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}
	@When("User add-formData and initialize the file location")
	public void userAddFormDataAndInitializeTheFileLocation() {
		addMultiPartFormData("profile_picture", new File(System.getProperty("user.dir")+"\\src\\test\\resources\\download.jpg"));
		
	}
	@When("User send {string} request for change profile picture endpoint")
	public void userSendRequestForChangeProfilePictureEndpoint(String type) {
		response = addReqType(type, Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User verify the Change Profile Picture response message matches with {string}")
	public void userVerifyTheChangeProfilePictureResponseMessageMatchesWith(String expectedValue) {
		ProfilePic_Output_Pojo pic_Output_Pojo = response.as(ProfilePic_Output_Pojo.class);
		String actualValue = pic_Output_Pojo.getMessage();
		Assert.assertEquals("Verify the Success message", expectedValue, actualValue);
	}



}
