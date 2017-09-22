package edu.ics211.h02;

import java.util.Comparator;

/**
 * Sorts data arrays.
 * Code for insertion, bubble, and selection sort from Koffman's Data Structures p.425-434.
 * 
 * @author kelseykato
 * @param <E> Generic class.
 */
public class ArraySorter<E> implements SortableArray<E> {
  private int swaps;
  private int comparisons;
  private double startTime;
  private double endTime;
  
  /**
  * Default constructor.
  */
  public ArraySorter() {
    this.swaps = 0;
    this.comparisons = 0;
    this.startTime = 0.0;
    this.endTime = 0.0;
  }
  
  /**
   * Method for sorting an array using insertion sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares data values.
   */
  public void insertionSort(E[] data, Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    int n = data.length;
    
    startTime = System.nanoTime();
    
    for (int nextPosition = 1; nextPosition < n; nextPosition++) {
      E nextValue = data[nextPosition];
      comparisons++;
      while (nextPosition > 0 && compare.compare(data[nextPosition - 1], nextValue) > 0) {
        data[nextPosition] = data[nextPosition - 1];
        comparisons++;
        nextPosition--;
      }
      if (data[nextPosition] != nextValue) {
        data[nextPosition] = nextValue;
        swaps++;
      }
      
    }
    endTime = System.nanoTime();
  }
  
  /**
   * Method for sorting an array using bubble sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares the data values.
   */
  public void bubbleSort(E[] data, Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    int n = data.length;
    boolean exchanges = false;
    int passes = 1;
    
    startTime = System.nanoTime();
    
    do { 
      exchanges = false;
      for (int i = 0; i < n - passes; i++) {
        comparisons++;
        if (compare.compare(data[i], data[i + 1]) > 0) {
          E temp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = temp;
          swaps++;
          exchanges = true;
        }
        
      }
      passes++;
    } while (exchanges);
    endTime = System.nanoTime();
  }
  
  /**
   * Method for sorting an array using selection sort.
   * 
   * @param data Array of data to be sorted.
   * @param compare Compares data values.
   */
  public void selectionSort(E[] data, Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    int n = data.length;
    int posMin = 0;
    
    startTime = System.nanoTime();
    
    for (int fill = 0; fill < n - 1; fill++) {
      posMin = fill; 
      for (int next = fill + 1; next < n; next++) {
        if (compare.compare(data[next], data[posMin]) < 0) {
          posMin = next; 
        }
        comparisons++;
      }
      if (posMin != fill) {
        E temp = data[posMin];
        data[posMin] = data[fill];
        data[fill] = temp;
        swaps++;
      }
   
    }
    endTime = System.nanoTime();
  }
  
  /**
   * Returns the number of swaps.
   * 
   * @return The number of swaps.
   */
  public int getNumberOfSwaps() {
    return swaps;
  }
  
  /**
   * Returns the number of comparisons.
   * 
   * @return The number of comparisons.
   */
  public int getNumberOfComparisons() {
    return comparisons;
  }
  
  /**
   * Returns the sort time in nanoseconds.
   * 
   * @return The sort time in nanoseconds.
   */
  public double getSortTime() {
    return endTime - startTime;
  }
  
}
