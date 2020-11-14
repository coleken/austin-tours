package com.example.austintours;

public class Attraction {

  private String name;
  private String hoursSunday;
  private String hoursMonday;
  private String hoursTuesday;
  private String hoursWednesday;
  private String hoursThursday;
  private String hoursFriday;
  private String hoursSaturday;
  private String addressLineOne;
  private String addressLineTwo;

  public Attraction() {
    // Default constructor
  }

  public Attraction(String name, String hoursSunday, String hoursMonday, String hoursTuesday,
      String hoursWednesday, String hoursThursday, String hoursFriday, String hoursSaturday,
      String addressLineOne, String addressLineTwo) {
    this.name = name;
    this.hoursSunday = hoursSunday;
    this.hoursMonday = hoursMonday;
    this.hoursTuesday = hoursTuesday;
    this.hoursWednesday = hoursWednesday;
    this.hoursThursday = hoursThursday;
    this.hoursFriday = hoursFriday;
    this.hoursSaturday = hoursSaturday;
    this.addressLineOne = addressLineOne;
    this.addressLineTwo = addressLineTwo;
  }

  public String getHoursTuesday() {
    return hoursTuesday;
  }

  public String getHoursWednesday() {
    return hoursWednesday;
  }

  public String getHoursThursday() {
    return hoursThursday;
  }

  public String getHoursFriday() {
    return hoursFriday;
  }

  public String getHoursSaturday() {
    return hoursSaturday;
  }

  public String getAddressLineTwo() {
    return addressLineTwo;
  }

  public String getName() {
    return name;
  }

  public String getHoursMonday() {
    return hoursMonday;
  }

  public String getHoursSunday() {
    return hoursSunday;
  }

  public String getAddressLineOne() {
    return addressLineOne;
  }
}
