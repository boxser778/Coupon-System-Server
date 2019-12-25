package com.Spring.CouponSystem.Beans;

import com.Spring.CouponSystem.Beans.Enum.ClientType;

public class ClientTypeConverter {

	public static ClientType convertStringToType(ClientType clientType) {

		switch (clientType) {
		case ADMIN:
			clientType = ClientType.ADMIN;
			break;
		case COMPANY:
			clientType = ClientType.COMPANY;
			break;
		case CUSTOMER:
			clientType = ClientType.CUSTOMER;
			break;
		default:
			break;
		}

		return clientType;

	}
}