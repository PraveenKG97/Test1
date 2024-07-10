package com.pojo.address;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserAddress_Output_Pojo {

	 private int status;
	    private String message;
	    private ArrayList<Datum> data;
}
