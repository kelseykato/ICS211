package edu.ics211.h02;

import java.util.Comparator;

/**
 * Interface for sorting arrays.
 * 
 * @author kelseykato
 * @param <E> Generic class.
 */
public interface SortableArray<E> {
  
  /**
   * Method for sorting an array using insertion sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares data values.
   */
  void insertionSort(E[] data, Comparator<E> compare);
  
  /**
   * Method for sorting an array using bubble sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares the data values.
   */
  void bubbleSort(E[] data, Comparator<E> compare);
  
  /**
   * Method for sorting an array using selection sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares data values.
   */
  void selectionSort(E[] data, Comparator<E> compare);
  
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
