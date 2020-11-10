package com.example.austintours;

public class Attraction {

  private String name;
  private String hours;
  private String days;
  private String address;

  public Attraction() {
    // Default constructor
  }

  public Attraction(String name, String days, String hours, String address) {
    this.name = name;
    this.days = days;
    this.hours = hours;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getDays() {
    return days;
  }

  public String getHours() {
    return hours;
  }

  public String getAddress() {
    return address;
  }
}
