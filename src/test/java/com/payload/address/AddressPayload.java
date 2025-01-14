package com.payload.address;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

public class AddressPayload {

	public AddUserAddress_Input_Pojo addAddressPayload(String first_name, String last_name, String mobile, String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return addUserAddress_Input_Pojo;
		
	}
	
	public UpdateUserAddress_Input_Pojo updateUserAddressPayload(String addressId, String first_name, String last_name, String mobile, String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		
		return updateUserAddress_Input_Pojo;
				
	}
	
	public DeleteUserAddress_Input_Pojo deleteUserAddress(String addressId) {
		
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(addressId);
		return deleteUserAddress_Input_Pojo;
		
		
	}
	
	public CityList_Input_Pojo getCityList(String stateId) {
		
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateId);
		return cityList_Input_Pojo;
		
		
		
	}
}
