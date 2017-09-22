package edu.ics211.h01;

/**
 * Class that represents an India Pale Ale.
 * 
 * @author kelseykato
 */
public class IndiaPaleAle extends Beer {
  private String name;

  /** 
   * Gets the name of the India Pale Ale.
   * 
   * @return The name of the India Pale Ale.
   */
  public String getName() {
    return name;
  }

  /** 
   * Sets the name of the India Pale Ale.
   * 
   * @param name The new name of the India Pale Ale.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Creates an instance of an India Pale Ale. 
   * Checks to see if the India Pale Ale's ibu and abv are within range.  
   * 
   * @param name The India Pale Ale's name.
   * @param ibu The India Pale Ale's International Bitterness Unit.
   * @param abv The India Pale Ale's Alcohol by Volume.
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    this.name = name;
    
    if (ibu < 40 || ibu > 100) {
      throw new IllegalArgumentException("ERROR: The ibu is not within the range, 25 - 45!");
    } else {
      this.ibu = ibu;
    }
    
    if (abv < 5.0 || abv > 10.0) {
      throw new IllegalArgumentException("ERROR: The abv is not within the range, 4.2 - 6.0!");
    } else {
      this.abv = abv;
    }
    
  }
  
  /**
   * Creates an instance of a India Pale Ale.
   * Assigns a random valid value to the India Pale Ale's ibu and abv.
   * 
   * @param name The name of the India Pale Ale.
   */
  public IndiaPaleAle(String name) {
    this.name = name;
    this.ibu = (int)(Math.random() * 60 + 40);
    this.abv = (Math.random() * 5.0 + 5.0);
  }

}
