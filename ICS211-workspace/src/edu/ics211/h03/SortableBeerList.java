package edu.ics211.h03;

import edu.ics211.h01.Beer;
import java.util.Comparator;

/**
 * Represents a sortable beer list.
 * Collaborated with Sabine.
 * 
 * @author kelseykato
 */
public class SortableBeerList implements IList211<Beer> {
  private SortableList<Beer> beerList = new SortableList<Beer>();
  private Comparator<Beer> comp;
  
  /**
   * Creates an instance of SortableBeerList.
   * 
   * @param compare Compares Beers by IBU or ABV and sorts them in ascending order.
   */
  public SortableBeerList(Comparator<Beer> compare) {
    this.comp = compare;
  }
  
  /**
   * Returns a reference to the beer at position index .
   * 
   * @param index The position of the beer in the list.
   * @return The beer at position index.
   */
  public Beer get(int index) {
    return beerList.get(index);
  }
  
  /**
   * Sets the beer at position index to reference the beer passed in.
   * 
   * @param index The position at which to insert the beer passed in.
   * @param beer The beer to be inserted at position index.
   * @return The previous value.
   */
  public Beer set(int index, Beer beer) {
    return beerList.set(index, beer);
  }
  
  
  /**
   * Returns the index of the first occurrence of the given beer in the list.
   * 
   * @param obj The beer index to find.
   * @return The index of the first occurrence of beer in the list or -1 if beer is not in the list.
   */
  public int indexOf(Object obj) {
    return beerList.indexOf(obj);
  }
  
  /**
   * Returns the current size of the list.
   * 
   * @return The current size of the list.
   */
  public int size() {
    return beerList.size();
  }
  
  /**
   * Adds a reference to beer at the end of the list.
   * 
   * @param b The beer to be added.
   * @return True when e is added to the end of the list.
   */
  public boolean add(Beer b) {
    beerList.add(b);
    beerList.insertionSort(comp);
    return true;
  }
  
  /**
   * Adds a reference to the beer passed in before the beer at position index.
   * Increments all beers at and after position index by 1.
   * 
   * @param index The position at which to add the beer passed in.
   * @param beer The beer to insert at position index.
   */
  public void add(int index, Beer beer) {
    beerList.add(index, beer);
    beerList.insertionSort(comp);
  }
  
  /**
   * Removes the beer at position index and shifts the beers that 
     follow it to fill the vacated space.
   * 
   * @param index The position of the element to remove.
   * @return The element that was removed.
   */
  public Beer remove(int index) {
    return beerList.remove(index);
  }
 
}
