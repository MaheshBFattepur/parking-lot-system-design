package com.parking.model;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public enum SlotState {
  OCCUPIED,
  UNOCCUPIED;

  public String toString() {
    return this.name();
  }
}
