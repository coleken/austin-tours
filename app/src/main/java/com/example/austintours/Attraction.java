package com.example.austintours;

public class Attraction {

  private String name;
  private String hours;
  private String address;
  private String website;
  private int photo;

  /**
   * Default attraction constructor.
   */
  public Attraction() {
    // Default constructor
  }

  /**
   * Constructor used to create an array list of custom attraction objects.
   *
   * @param name    A string for the name of the attraction.
   * @param hours   A string for the hours of operation
   * @param address A string for the address.
   * @param website A string for the website.
   * @param photo   An int for the id of the attraction photo.
   */
  public Attraction(String name, String hours, String website, String address,
      int photo) {
    this.hours = hours;
    this.name = name;
    this.address = address;
    this.website = website;
    this.photo = photo;
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
  public String getHours() {
    return hours;
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
   * Returns a string with the attraction website.
   *
   * @return A string with the attraction website.
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Returns an int containing the resource identifier of the attraction photo.
   *
   * @return An int with the resource identifier of the attraction photo.
   */
  public int getPhoto() {
    return photo;
  }
}
