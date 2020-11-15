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
  private String attractionAddress;
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
   * @param name              A string for the name of the attraction.
   * @param hoursSunday       A string for the availability on Sunday.
   * @param hoursMonday       A string for the availability on Monday.
   * @param hoursTuesday      A string for the availability on Tuesday.
   * @param hoursWednesday    A string for the availability on Wednesday.
   * @param hoursThursday     A string for the availability on Thursday.
   * @param hoursFriday       A string for the availability on Friday.
   * @param hoursSaturday     A string for the availability on Saturday.
   * @param attractionAddress A string for the address.
   * @param attractionPhoto   An int for the id of the attraction photo.
   */
  public Attraction(String name, String hoursSunday, String hoursMonday, String hoursTuesday,
      String hoursWednesday, String hoursThursday, String hoursFriday, String hoursSaturday,
      String attractionAddress, int attractionPhoto) {
    this.name = name;
    this.hoursSunday = hoursSunday;
    this.hoursMonday = hoursMonday;
    this.hoursTuesday = hoursTuesday;
    this.hoursWednesday = hoursWednesday;
    this.hoursThursday = hoursThursday;
    this.hoursFriday = hoursFriday;
    this.hoursSaturday = hoursSaturday;
    this.attractionAddress = attractionAddress;
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
   * Returns a string containing the attraction address.
   *
   * @return A string with the address of the attraction.
   */
  public String getAttractionAddress() {
    return attractionAddress;
  }

  /**
   * Returns Sunday availability hours.
   *
   * @return A string with the availability hours for Sunday.
   */
  public String getHoursSunday() {
    return hoursSunday;
  }

  /**
   * Returns Monday availability hours.
   *
   * @return A string with the availability hours for Monday.
   */
  public String getHoursMonday() {
    return hoursMonday;
  }

  /**
   * Returns Tuesday availability hours.
   *
   * @return A string with the availability hours for Tuesday.
   */
  public String getHoursTuesday() {
    return hoursTuesday;
  }

  /**
   * Returns Wednesday availability hours.
   *
   * @return A string with the availability hours for Wednesday.
   */
  public String getHoursWednesday() {
    return hoursWednesday;
  }

  /**
   * Returns Thursday availability hours.
   *
   * @return A string with the availability hours for Thursday.
   */
  public String getHoursThursday() {
    return hoursThursday;
  }

  /**
   * Returns Friday availability hours.
   *
   * @return A string with the availability hours for Friday.
   */
  public String getHoursFriday() {
    return hoursFriday;
  }

  /**
   * Returns Saturday availability hours.
   *
   * @return A string with the availability hours for Saturday.
   */
  public String getHoursSaturday() {
    return hoursSaturday;
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
