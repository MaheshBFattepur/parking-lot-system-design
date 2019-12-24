package com.parking.utils;

import java.util.HashMap;

import com.parking.model.Ticket;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public interface Constants {

  static final String CREATE_TICKET = "/createTicket";
  static final String GET_PRICE = "/generatePrice/{ticketId}";
  static final String GET_ALL_SLOTS = "/getAllSlots";
  static final String GET_AVAILABLE_SLOTS = "/getAvailableSlots";
  static final Integer TOTAL_SLOT_AVAILABLE = 20;
  static String[] location = new String[] { "Floor - 1", "Floor - 2", "Floor - 3" };
  static HashMap<Integer, Ticket> tmap = new HashMap<Integer, Ticket>();

}
