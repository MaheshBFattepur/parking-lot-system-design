package com.parking.model;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public enum VehicleTypeSlots {

  SMALL(10),
  MEDIUM(5),
  LARGE(5);

  private int availbleSlots;

  VehicleTypeSlots(int availbleSlots) {
    this.availbleSlots = availbleSlots;
  }

  public int getAvailbleSlots() {
    return this.availbleSlots;
  }
}
