package com.pojo.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUserAddress_Output_Pojo {

	 private int status;
	    private String message;
	    private int address_id;
}
