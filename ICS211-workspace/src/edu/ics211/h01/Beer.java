package edu.ics211.h01;

/**
 * Class representing a beer.
 * 
 * @author kelseykato
 */
public abstract class Beer implements Comparable<Beer> {
  private String name;
  private String type;
  protected Integer ibu;
  protected Double abv;
  
  /**
   * Default constructor.
   */
  public Beer() {
    this.name = "";
    this.type = "";
  }
  
  /**
   * Constructs a Beer with given name and type.
   * @param name The name of the Beer.
   * @param type The type of the Beer.
   */
  public Beer(String name, String type) {
    this.name = name;
    this.type = type;
  }
  
  /**
   * Constructs a Beer with the given type, ibu, and abv.
   * @param name The name of the Beer.
   * @param type The type of the Beer.
   * @param ibu The ibu of the Beer.
   * @param abv The abv of the Beer.
   */
  public Beer(String name, String type, Integer ibu, Double abv) {
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }
  
  /**
   * Gets the name of the given Beer.
   * @return The name of the Beer.
   */
  public String getName() {
    return name;
  }
  
  /**
   * Sets the name of the Beer. 
   * @param newName The new name of the Beer.
   */
  public void setName(String newName) {
    this.name = newName;
  }
  
  /**
   * Gets the type of the given Beer.
   * @return The type of the Beer.
   */
  public String getType() {
    return type;
  }
  
  /**
   * Gets the ibu of the Beer.
   * @return The ibu of the Beer.
   */
  public Integer getIbu() {
    return ibu;
  }
  
  /**
   * Gets the abv of the Beer.
   * @return The abv of the Beer.
   */
  public Double getAbv() {
    return abv;
  }
  
  /**
   * Compares the names of two Beers.
   * @param x The Beer being compared.
   * @return 0 if the beers have the same name, a positive or negative integer if not.
   */
  public int compareTo(Beer x) {
    return this.name.compareTo(x.getName());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((abv == null) ? 0 : abv.hashCode());
    result = prime * result + ((ibu == null) ? 0 : ibu.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Beer other = (Beer) obj;
    if (abv == null) {
      if (other.abv != null) {
        return false;
      }
    } else if (!abv.equals(other.abv)) {
      return false;
    }
    if (ibu == null) {
      if (other.ibu != null) {
        return false;
      }
    } else if (!ibu.equals(other.ibu)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }
   
}
