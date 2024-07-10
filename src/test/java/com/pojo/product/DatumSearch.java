package com.pojo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatumSearch {

	 private String image;
	    private String type;
	    private String text;
	    private int id;
	    private int category_id;
}
