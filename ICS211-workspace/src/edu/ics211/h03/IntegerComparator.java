package edu.ics211.h03;

import java.util.Comparator;

/**
 * Represents an IntegerComparator.
 * 
 * @author kelseykato
 */
public class IntegerComparator implements Comparator<Integer> {
  
  /**
   * Compares the values of two Integers.
   * @param a The first Integer being compared.
   * @param b The second Integer being compared.
   * @return A positive integer if a is greater than b. 
   A negative integer if a is less than b , 0 if a and b are equal.
   */
  public int compare(Integer a, Integer b) {
    return Integer.compare(a, b);
  }
 
}
