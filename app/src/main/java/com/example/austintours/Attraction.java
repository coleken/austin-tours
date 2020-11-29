package com.example.austintours;

import android.graphics.drawable.Drawable;

/**
 * A custom class that contains attraction location information.
 */
public class Attraction {

  private String name;
  private String hours;
  private String address;
  private String website;
  private Drawable photo;

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
   * @param photo   A drawable of the attraction photo.
   */
  public Attraction(String name, String hours, String website, String address, Drawable photo) {
    this.name = name;
    this.hours = hours;
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
   * Returns a drawable of the attraction photo.
   *
   * @return A drawable of the attraction photo.
   */
  public Drawable getPhoto() {
    return photo;
  }
}
