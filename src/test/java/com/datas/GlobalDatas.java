package com.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlobalDatas {

		private int statusCode;
		private String logToken;
		private int stateId;
		private int cityId;
		private String addressId;
}
