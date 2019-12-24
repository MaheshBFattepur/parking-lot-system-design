package com.parking.services;

import java.util.List;

import com.parking.model.Ticket;
import com.parking.model.VehicleTypePrice;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public interface UserService {

  Integer getPrice(Integer ticketId);

  Ticket getTicket(String vehicleNumber, VehicleTypePrice vehicleType);
}
