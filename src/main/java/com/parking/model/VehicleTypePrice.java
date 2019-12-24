package com.parking.model;

/**
 * 
 * @author Mahesh B Fattepur [fathepur.m@gmail.com]
 *
 */
public enum VehicleTypePrice {

  SMALL(10),
  MEDIUM(10),
  LARGE(10);

  private int price;

  VehicleTypePrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }
}
