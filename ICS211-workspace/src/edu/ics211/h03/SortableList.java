package edu.ics211.h03;

import edu.ics211.h02.ArraySorter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Class that represents a sortable list.
 * Code for IList and ISortable methods + reallocate method from Koffman's Data Structures p.72-76.
 * 
 * @author kelseykato
 * @param <E> The generic class.
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private ArraySorter<E> sorter = new ArraySorter<E>();
  private static final int INITIAL_CAPACITY = 10; 
  private E[] data;
  private int size;
  private int capacity;
  private int swaps;
  private int comparisons;
  private double startTime;
  private double endTime;
  
  /**
   * Default constructor.
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    size = 0;
    capacity = INITIAL_CAPACITY;
    data = (E[]) new Object[capacity];
  }
 
  /**
   * Returns a reference to the element at position index .
   * 
   * @param index The position of the element in the list.
   * @return The element at position index.
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
    }
    return data[index];
  }
  
  /**
   * Sets the element at position index to reference the element passed in.
   * 
   * @param index The position at which to insert the element passed in.
   * @param element The element to be inserted at position index.
   * @return The previous value.
   */
  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
    }
    E temp = data[index];
    data[index] = element;
    return temp;
  }
  
  
  /**
   * Returns the index of the first occurrence of the given element in the list.
   * 
   * @param obj The element index to find.
   * @return The index of the first occurrence of obj in the list or -1 if obj is not in the list.
   */
  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (obj.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * Returns the current size of the list.
   * 
   * @return The current size of the list.
   */
  public int size() {
    return size;
  }
  
  /**
   * Adds a reference to e at the end of the list.
   * 
   * @param e The element to be added.
   * @return True when e is added to the end of the list.
   */
  public boolean add(E e) {
    if (capacity == size) {
      reallocate();
    }
    data[size] = e;
    size++;
   
    return true;
  }
  
  /**
   * Adds a reference to the element passed in before the element at position index.
   * Increments all elements at and after position index by 1.
   * 
   * @param index The position at which to add the element passed in.
   * @param element The element to insert at position index.
   */
  public void add(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
    }
    if (capacity == size) {
      reallocate();
    }
    for (int i = size(); i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    size++;
  }
  
  /**
   * Removes the element at position index and shifts the elements that 
     follow it to fill the vacated space.
   * 
   * @param index The position of the element to remove.
   * @return The element that was removed.
   */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
    }
    E temp = data[index];
    for (int i = index; i < size(); i++) {
      data[i + 1] = data[i];
    }
    size--;
    return temp;
  }
  
  /**
   * Doubles the capacity of the data array.
   */
  public void reallocate() {
    capacity = capacity * 2;
    data = Arrays.copyOf(data, capacity);
  }
  
  /**
   * Method for sorting a list using insertion sort.
   * 
   * @param compare Compares data values.
   */
  public void insertionSort(Comparator<E> compare) {
    E[] temp = Arrays.copyOf(data, size);
    sorter.insertionSort(temp, compare);
    data = Arrays.copyOf(temp, data.length);
  }
  
  /**
   * Method for sorting a list using bubble sort.
   * 
   * @param compare Compares the data values.
   */
  public void bubbleSort(Comparator<E> compare) {
    E[] temp = Arrays.copyOf(data, size);
    sorter.bubbleSort(temp, compare);
    data = Arrays.copyOf(temp, data.length);
  }
  
  /**
   * Method for sorting a list using selection sort.
   * 
   * @param compare Compares data values.
   */
  public void selectionSort(Comparator<E> compare) {
    E[] temp = Arrays.copyOf(data, size);
    sorter.selectionSort(temp, compare);
    data = Arrays.copyOf(temp, data.length);
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
