package edu.ics211.h04;

/**
 * Interface for a list.
 * 
 * @author kelseykato
 *
 * @param <E> The generic class.
 */
public interface IList211<E> {
  
  /**
   * Returns a reference to the element at position index .
   * 
   * @param index The position of the element in the list.
   * @return The element at position index.
   */
  E get(int index);
  
  /**
   * Sets the element at position index to reference the element passed in.
   * 
   * @param index The position at which to insert the element passed in.
   * @param element The element to be inserted at position index.
   * @return The previous value.
   */
  E set(int index, E element);
  
  
  /**
   * Returns the index of the first occurrence of the given element in the list.
   * 
   * @param obj The element index to find.
   * @return The index of the first occurrence of obj in the list or -1 if obj is not in the list.
   */
  int indexOf(Object obj);
  
  /**
   * Returns the current size of the list.
   * 
   * @return The current size of the list.
   */
  int size();
  
  /**
   * Adds a reference to e at the end of the list.
   * 
   * @param e The element to be added.
   * @return True when e is added to the end of the list.
   */
  boolean add(E e);
  
  /**
   * Adds a reference to the element passed in before the element at position index.
   * Increments all elements at and after position index by 1.
   * 
   * @param index The position at which to add the element passed in.
   * @param element The element to insert at position index.
   */
  void add(int index, E element);
  
  /**
   * Removes the element at position index and shifts the elements that 
     follow it to fill the vacated space.
   * 
   * @param index The position of the element to remove.
   * @return The element that was removed.
   */
  E remove(int index);
}
