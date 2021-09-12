package com.booking.ny.error;


public class MissingCustomerError extends RuntimeException  {

	public MissingCustomerError() {
		super("Customer details is missing in JSON");
	}
}
