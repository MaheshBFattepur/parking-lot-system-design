package com.parking.services.impl;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import com.parking.model.ParkingSlot;
import com.parking.model.SlotState;
import com.parking.model.Ticket;
import com.parking.model.VehicleTypePrice;
import com.parking.model.VehicleTypeSlots;
import com.parking.services.UserService;
import com.parking.utils.Constants;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
@Service
public class UserServiceimpl implements UserService {
  public static Integer ticketId = 0;
  public static Integer parkingSlotId = 0;

  public static Integer smallSlot = 0;
  public static Integer mediumSlot = 0;
  public static Integer largeSlot = 0;

  @Override
  public Ticket getTicket(String vehicleNumber, VehicleTypePrice vehicleType) {

    Ticket ticket = increamentVehicleSlot(vehicleType);
    if (ticket.status.contains("No Slots")) {
      return ticket;
    }

    parkingSlotId = smallSlot + mediumSlot + largeSlot;

    if (parkingSlotId + 1 > Constants.TOTAL_SLOT_AVAILABLE) {
      return new Ticket(null, null, null, null, "No Slots are available");
    }

    Integer id = ticketId + 1;
    ticket = new Ticket(id, vehicleNumber, new Date(),
        new ParkingSlot(parkingSlotId++, vehicleType, SlotState.OCCUPIED), SlotState.OCCUPIED.toString());

    ticketId++;
    Constants.tmap.put(id, ticket);
    return ticket;
  }

  @Override
  public Integer getPrice(Integer ticketId) {

    Ticket ticket = Constants.tmap.get(ticketId);

    if (ticket == null) {
      return 0;
    }

    Date d1 = ticket.startTime;
    Date d2 = new Date();

    long duration = d2.getTime() - d1.getTime();
    long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

    if (diffInHours == 0) {
      diffInHours = 1;
    }

    decreamentVehicleSlot(ticket.ParkingSlot.vehicleType);

    parkingSlotId = smallSlot + mediumSlot + largeSlot;
    Constants.tmap.remove(ticketId);

    return (int) (ticket.ParkingSlot.vehicleType.getPrice() * diffInHours);
  }

  private Ticket increamentVehicleSlot(VehicleTypePrice vehicleType) {
    switch (vehicleType) {
    case SMALL:
      smallSlot++;
      if (smallSlot > VehicleTypeSlots.SMALL.getAvailbleSlots()) {
        smallSlot--;
        return new Ticket(null, null, null, null, "No Slots are available");
      }
      return new Ticket(null, null, null, null, "GOOD");
    case MEDIUM:
      mediumSlot++;
      if (mediumSlot > VehicleTypeSlots.MEDIUM.getAvailbleSlots()) {
        mediumSlot--;
        return new Ticket(null, null, null, null, "No Slots are available");
      }
      return new Ticket(null, null, null, null, "GOOD");
    case LARGE:
      largeSlot++;
      if (largeSlot > VehicleTypeSlots.LARGE.getAvailbleSlots()) {
        largeSlot--;
        return new Ticket(null, null, null, null, "No Slots are available");
      }
      return new Ticket(null, null, null, null, "GOOD");
    }

    return new Ticket(null, null, null, null, "No Slots are available - WRONG vehicle type");
  }

  private void decreamentVehicleSlot(VehicleTypePrice vehicleType) {
    switch (vehicleType) {
    case SMALL:
      if (smallSlot > 0) {
        smallSlot--;
      }
      break;
    case MEDIUM:
      if (mediumSlot > 0) {
        mediumSlot--;
      }
      break;
    case LARGE:
      if (largeSlot > 0) {
        largeSlot--;
      }
      break;
    }
  }
}
