package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.FlightModel;

/*
 * PilotService
 */

public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	List<FlightModel> getAllFlightByFlightNumber(String flightNumber);
}
