package edu.ics211.h04;

import java.util.Comparator;

/**
 * Represents a SortableList using a doubly linked list implementation.
 *
 * @param <E> The generic class.
 * 
 * @author kelseykato
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private DLinkedNode head; 
  private DLinkedNode tail;
  private int size;
  private int swaps;
  private int comparisons;
  private double startTime;
  private double endTime;
  
  /**
   * Represents a doubly linked node.
   * 
   * @author kelseykato
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
    
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
    
  }
  
  /**
   * Default constructor.
   */
  public SortableList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  
  /**
   * Method for sorting a list using insertion sort.
   * 
   * @param compare Compares data values.
   */
  public void insertionSort(Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    
    startTime = System.nanoTime();
    
    for (int nextPosition = 1; nextPosition < size; nextPosition++) {
      E nextValue = get(nextPosition);
      comparisons++;
      while (nextPosition > 0 && compare.compare(get(nextPosition - 1), nextValue) > 0) {
        set(nextPosition, get(nextPosition - 1));
        comparisons++;
        nextPosition--;
      }
      if (get(nextPosition) != nextValue) {
        set(nextPosition, nextValue);
        swaps++;
      }
      
    }
    endTime = System.nanoTime();
  }
  
  /**
   * Method for sorting a list using bubble sort.
   * 
   * @param compare Compares the data values.
   */
  public void bubbleSort(Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    boolean exchanges = false;
    int passes = 1;
    
    startTime = System.nanoTime();
    
    do { 
      exchanges = false;
      for (int i = 0; i < size - passes; i++) {
        comparisons++;
        if (compare.compare(get(i), get(i + 1)) > 0) {
          E temp = get(i);
          set(i, get(i + 1));
          set(i + 1, temp);
          swaps++;
          exchanges = true;
        }
        
      }
      passes++;
    } while (exchanges);
    endTime = System.nanoTime();
  }
  
  /**
   * Method for sorting a list using selection sort.
   * 
   * @param compare Compares data values.
   */
  public void selectionSort(Comparator<E> compare) {
    startTime = 0.0;
    endTime = 0.0;
    swaps = 0;
    comparisons = 0;
    int posMin = 0;
    
    startTime = System.nanoTime();
    
    for (int fill = 0; fill < size - 1; fill++) {
      posMin = fill; 
      for (int next = fill + 1; next < size; next++) {
        if (compare.compare(get(next), get(posMin)) < 0) {
          posMin = next; 
        }
        comparisons++;
      }
      if (posMin != fill) {
        E temp = get(posMin);
        set(posMin, get(fill));
        set(fill, temp);
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
  
  /**
   * Returns a reference to the element at position index .
   * 
   * @param index The position of the element in the list.
   * @return The element at position index.
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERRROR: The index you entered is not in this list!");
    }
    DLinkedNode temp = head;
    for (int i = 0; i < index && temp != null; i++) {
      temp = temp.next;
    }
    return temp.item;
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
      throw new IndexOutOfBoundsException("ERRROR: The index you entered is not in this list!");
    }
    DLinkedNode temp = head;
    for (int i = 0; i < index && temp != null; i++) {
      temp = temp.next;
    }
    E returnValue = temp.item;
    temp.item = element;
    return returnValue;
  }
    
    
  /**
   * Returns the index of the first occurrence of the given element in the list.
   * 
   * @param obj The element index to find.
   * @return The index of the first occurrence of obj in the list or -1 if obj is not in the list.
   */
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.item.equals(obj)) { 
        return i;
      }
      temp = temp.next;
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
    if (size == 0) {
      head = new DLinkedNode(e, null, null);
      tail = head;
    } else {
      tail = new DLinkedNode(e, null, tail);
      tail.prev.next = tail;
    }
    size++;
    return true;
  }
    
  /**
   * Adds a reference to the element passed in before the element at position index.
   * Shifts all nodes after index, one position to the right.
   * 
   * @param index The position at which to add the element passed in.
   * @param element The element to insert at position index.
   */
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("ERRROR: The index you entered is not in this list!");
    }
    if (index == 0) {
      head = new DLinkedNode(element, head, null);
      head.next.prev = head;
    } else if (index == size) {
      tail = new DLinkedNode(element, null, tail);
      tail.prev.next = tail;
    } else { 
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      temp.next = new DLinkedNode(element, temp.next, temp);
      temp.next.prev = temp.next;
    }
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
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("ERRROR: The index you entered is not in this list!");
    }
    if (index == 0) {
      E returnValue = head.item;
      head = head.next;
      head.next.prev = null;
      size--;
      return returnValue;
    } 
    DLinkedNode temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.next;
    }
    E returnValue = temp.next.item;
    temp.next = temp.next.next;
    temp.next.next.prev = temp;
    size--;
    return returnValue;
  }
   
}
