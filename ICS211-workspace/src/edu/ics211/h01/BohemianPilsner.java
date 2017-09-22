package edu.ics211.h01;

/**
 * Class that represents a Bohemian Pilsner.
 * 
 * @author kelseykato
 */
public class BohemianPilsner extends Pilsner {
  private String name;

  /** 
   * Gets the name of the Bohemian Pilsner.
   * 
   * @return The name of the Bohemian Pilsner.
   */
  public String getName() {
    return name;
  }

  /** 
   * Sets the name of the Bohemian Pilsner.
   * 
   * @param name The new name of the Bohemian Pilsner.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Creates an instance of a Bohemian Pilsner. 
   * Checks to see if the Bohemian Pilsner's ibu and abv are within range.  
   * 
   * @param name The Bohemian Pilsner's name.
   * @param ibu The Bohemian Pilsner's International Bitterness Unit.
   * @param abv The Bohemian Pilsner's Alcohol by Volume.
   */
  public BohemianPilsner(String name, Integer ibu, Double abv) {
    this.name = name;
    
    if (ibu < 35 || ibu > 45) {
      throw new IllegalArgumentException("ERROR: The ibu is not within the range, 25 - 45!");
    } else {
      this.ibu = ibu;
    }
    
    if (abv < 4.2 || abv > 5.4) {
      throw new IllegalArgumentException("ERROR: The abv is not within the range, 4.2 - 6.0!");
    } else {
      this.abv = abv;
    }
    
  }
  
  /**
   * Creates an instance of a Bohemian Pilsner.
   * Assigns a random valid value to the Bohemian Pilsner's ibu and abv.
   * 
   * @param name The name of the Bohemian Pilsner.
   */
  public BohemianPilsner(String name) {
    this.name = name;
    this.ibu = (int)(Math.random() * 10 + 35);
    this.abv = (Math.random() * 1.2 + 4.2);
  }
  
}
