package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parking.model.Ticket;
import com.parking.model.VehicleTypePrice;
import com.parking.services.UserService;
import com.parking.utils.Constants;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
@RequestMapping("/api/")
@RestController
public class PublicApis {
  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.POST, value = Constants.CREATE_TICKET)
  public Ticket getTicket(@RequestParam String vehicleNumber, @RequestParam VehicleTypePrice vehicleType) {
    return userService.getTicket(vehicleNumber, vehicleType);
  }

  @RequestMapping(method = RequestMethod.GET, value = Constants.GET_PRICE)
  public Integer getPrice(@PathVariable Integer ticketId) {
    return userService.getPrice(ticketId);
  }
}
