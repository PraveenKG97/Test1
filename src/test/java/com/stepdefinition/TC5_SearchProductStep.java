package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.product.ProductPayload;
import com.pojo.product.DatumSearch;
import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass{

	ProductPayload productPayload = new ProductPayload();
	Response response ;

	@Given("User add header for accessing search product endpoints")
	public void userAddHeaderForAccessingSearchProductEndpoints() {
List<Header> lstheader = new ArrayList<>();
		
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		
		lstheader.add(h1);
		lstheader.add(h2);
		
		
		Headers headers = new Headers(lstheader);
		addHeaders(headers);
	}
	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String string) {
	   SearchProduct_Input_Pojo searchProductPayload = productPayload.searchProductPayload(string);
	   addReqBody(searchProductPayload);
	}
	@When("User send {string} request for SearchProduct endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		response = addReqType(type, Endpoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}
	@Then("User should verify the SearchProduct response message matches product type is {string}")
	public void userShouldVerifyTheSearchProductResponseMessageMatchesProductTypeIs(String expectedValue) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		DatumSearch datumSearch = searchProduct_Output_Pojo.getData().get(0);
		String actualValue = datumSearch.getType();
		Assert.assertEquals("Verify Search Product", expectedValue, actualValue);
		
	}

}
