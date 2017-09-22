package edu.ics211.h01;

import java.util.Comparator;

/**
 * Compares the IBU values of beers.
 * @author kelseykato
 */
public class IbuComparator implements Comparator<Beer> {
  
  /**
   * Compares the IBU values of two beers.
   * @param a The first beer being compared.
   * @param b The second beer being compared.
   * @return A positive integer if a's IBU is greater than b's IBU. 
   A negative integer if a's IBU is less than b's IBU, 0 if IBU's are equal.
   */
  public int compare(Beer a, Beer b) {
    return a.ibu.compareTo(b.ibu);
  }
  
}
