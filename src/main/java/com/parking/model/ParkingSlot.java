package com.parking.model;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public class ParkingSlot {
  public Integer parkingSlotId;
  public VehicleTypePrice vehicleType;
  public SlotState slotState;

  public ParkingSlot(Integer parkingSlotId, VehicleTypePrice vehicleType, SlotState slotState) {
    this.vehicleType = vehicleType;
    this.slotState = slotState;
    this.parkingSlotId = parkingSlotId;
  }
}
