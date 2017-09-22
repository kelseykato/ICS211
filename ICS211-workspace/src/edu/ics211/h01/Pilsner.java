package edu.ics211.h01;

import java.lang.IllegalArgumentException;

/**
 * Class that represents a Pilsner.
 * 
 * @author kelseykato
 */
public class Pilsner extends Beer {
  private String name;

  /** 
   * Gets the name of the Pilsner.
   * 
   * @return The name of the Pilsner.
   */
  public String getName() {
    return name;
  }

  /** 
   * Sets the name of the Pilsner.
   * 
   * @param name The new name of the Pilsner.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Default constructor.
   */
  public Pilsner() {
    this.name = "";
    this.ibu = 0;
    this.abv = 0.0;
  }
  
  /**
   * Creates an instance of a Pilsner. 
   * Checks to see if the Pilsner's ibu and abv are within range.  
   * 
   * @param name The Pilsner's name.
   * @param ibu The Pilsner's International Bitterness Unit.
   * @param abv The Pilsner's Alcohol by Volume.
   */
  public Pilsner(String name, Integer ibu, Double abv) {
    this.name = name;
    
    if (ibu < 25 || ibu > 45) {
      throw new IllegalArgumentException("ERROR: The ibu is not within the range, 25 - 45!");
    } else {
      this.ibu = ibu;
    }
    
    if (abv < 4.2 || abv > 6.0) {
      throw new IllegalArgumentException("ERROR: The abv is not within the range, 4.2 - 6.0!");
    } else {
      this.abv = abv;
    }
    
  }
  
  /**
   * Creates an instance of a Pilsner.
   * Assigns a random valid value to the Pilsner's ibu and abv.
   * 
   * @param name The name of the Pilsner.
   */
  public Pilsner(String name) {
    this.name = name;
    this.ibu = (int)(Math.random() * 20 + 25);
    this.abv = (Math.random() * 1.8 + 4.2);
  }

}
