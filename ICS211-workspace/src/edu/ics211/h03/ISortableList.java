package edu.ics211.h03;

import java.util.Comparator;

/**
 * Interface for a sortable list.
 * 
 * @author kelseykato
 *
 * @param <E> The generic class.
 */
public interface ISortableList<E> {
  
  /**
   * Method for sorting a list using insertion sort.
   * 
   * @param compare Compares data values.
   */
  void insertionSort(Comparator<E> compare);
  
  /**
   * Method for sorting a list using bubble sort.
   * 
   * @param compare Compares the data values.
   */
  void bubbleSort(Comparator<E> compare);
  
  /**
   * Method for sorting a list using selection sort.
   * 
   * @param compare Compares data values.
   */
  void selectionSort(Comparator<E> compare);
  
  /**
   * Returns the number of swaps.
   * 
   * @return The number of swaps.
   */
  int getNumberOfSwaps();
  
  /**
   * Returns the number of comparisons.
   * 
   * @return The number of comparisons.
   */
  int getNumberOfComparisons();
  
  /**
   * Returns the sort time in nanoseconds.
   * 
   * @return The sort time in nanoseconds.
   */
  double getSortTime();
}
