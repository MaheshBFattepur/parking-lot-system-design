package com.parking.model;

import java.util.Date;

import com.parking.utils.Constants;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public class Ticket {
  public Integer ticketId;
  public String location;
  public String vehicleNumber;
  public Date startTime;
  public ParkingSlot ParkingSlot;
  public String status;

  public Ticket(Integer ticketId, String vehicleNumber, Date startTime, ParkingSlot parkingSlot, String status) {
    this.ticketId = ticketId;
    this.vehicleNumber = vehicleNumber;
    this.startTime = startTime;
    ParkingSlot = parkingSlot;
    if (parkingSlot != null) {
      this.location = Constants.location[parkingSlot.parkingSlotId % 3];
    } else {
      this.location = null;
    }
    this.status = status;
  }

}
