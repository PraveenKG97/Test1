package com.pojo.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfilePic_Output_Pojo {

	private int status;
	private String message;
	private ProfileData data;
	private int cart_count;
	
}
