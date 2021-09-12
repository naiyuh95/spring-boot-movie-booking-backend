package com.booking.ny.error;


public class SeatsNotAvailableException extends RuntimeException  {

	public SeatsNotAvailableException() {
		super("Seats selected are not available, please refresh the page and try again.");
	}
}
