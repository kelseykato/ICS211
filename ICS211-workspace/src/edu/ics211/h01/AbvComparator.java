package edu.ics211.h01;

import java.util.Comparator;

/**
 * Compares the ABV values of beers.
 * @author kelseykato
 */
public class AbvComparator implements Comparator<Beer> {
  
  /**
   * Compares the ABV values of two beers.
   * @param a The first beer being compared.
   * @param b The second beer being compared.
   * @return A positive integer if a's ABV is greater than b's ABV. 
   A negative integer if a's ABV is less than b's ABV, 0 if ABV's are equal.
   */
  public int compare(Beer a, Beer b) {
    return Double.compare(a.abv, b.abv);
  }
 
}
