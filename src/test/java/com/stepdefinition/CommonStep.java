package com.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {

	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(int expValue) {
		
	    int actValue = TC1_LoginStep.globalDatas.getStatusCode();
	    Assert.assertEquals("Verify status code",expValue, actValue);
	}
}
