package com.pojo.product;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchProduct_Output_Pojo {

	 private int status;
	    private String message;
	    private ArrayList<DatumSearch> data;
	    private String currency;
}
