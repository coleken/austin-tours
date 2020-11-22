package com.example.austintours;

public class Attraction {

  private String name;
  private String hoursOfOperation;
  private String address;
  private int attractionPhoto;

  /**
   * Default attraction constructor.
   */
  public Attraction() {
    // Default constructor
  }

  /**
   * Constructor used to create an array list of custom attraction objects.
   *
   * @param name             A string for the name of the attraction.
   * @param hoursOfOperation A string for the hours of operation
   * @param address          A string for the address.
   * @param attractionPhoto  An int for the id of the attraction photo.
   */
  public Attraction(String name, String hoursOfOperation, String address, int attractionPhoto) {
    this.hoursOfOperation = hoursOfOperation;
    this.name = name;
    this.address = address;
    this.attractionPhoto = attractionPhoto;
  }

  /**
   * Returns a string containing the attraction name.
   *
   * @return A string with the name of the attraction.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the hours of operation of the attraction.
   *
   * @return A string with the hours of operation.
   */
  public String getHoursOfOperation() {
    return hoursOfOperation;
  }

  /**
   * Returns a string containing the attraction address.
   *
   * @return A string with the address of the attraction.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns an int containing the resource identifier of the attraction photo.
   *
   * @return An int with the resource identifier of the attraction photo.
   */
  public int getAttractionPhoto() {
    return attractionPhoto;
  }
}
