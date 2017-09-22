package edu.ics211.h01;

/**
 * Singleton class that can create Beers, Pilsners, Bohemian Pilsners, and IndiaPaleAles.
 * Help from BJ (TA) on brewBeer method.
 * @author kelseykato
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;
  
  /** Hide the default constructor so that no one else can create an instance. */
  private ManoaBrewing() {}
  
  /**
   * Gets the singleton instance of ManoaBrewing.
   * 
   * @return The singleton instance of ManoaBrewing.
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      return new ManoaBrewing();
    } else {
      return instance;
    }
  }
  
  /**
   * Brews the beer with the given type.
   * 
   * @param name the name of the beer.
   * @param type the type of the beer.
   * @return the beer.
   */
  public Beer brewBeer(String name, String type) {
    if (type == IBrewery.PILSNER) {
      return new Pilsner(name);
    }
    if (type == IBrewery.BOHEMIAN_PILSNER) {
      return new BohemianPilsner(name);
    }
    if (type == IBrewery.INDIA_PALE_ALE) {
      return new IndiaPaleAle(name); 
    }
    throw new IllegalArgumentException("ERROR: Not one of the valid Beer types!");
  }

  
  /**
   * Brews a Pilsner with the given name, ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Pilsner.
   */
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    return new Pilsner(name, ibu, abv);
  }


  /**
   * Brews a Bohemian Pilsner with the given name, ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Bohemian Pilsner.
   */
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    return new BohemianPilsner(name, ibu, abv);
  }


  /**
   * Brews an India Pale Ale with the given ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return an India Pale Ale.
   */
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    return new IndiaPaleAle(name, ibu, abv);
  }

}
