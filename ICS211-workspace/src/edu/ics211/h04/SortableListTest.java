package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a SortableListTest.
 * Testing strategy: I created an Integer array with three sorted elements
   to serve as my basis for comparison when testing my list methods.
   I then created a SortableList array of type Integer identical to my Integer array
   to test my list methods.
   I also made two other SortableList arrays of type Integer to test my 3 sort methods.
   I populated one array with the same 3 elements as my Integer array, but in reverse order 
   and the other array with the same 3 elements in a random order.
   Here I wanted to test to make sure that my sort methods successfully sort an array 
   regardless of the order of the elements.
   I checked each element from index 0 to 2 with its respective element in my Integer array
   to make sure all the elements were sorted properly and that there were no errors occurring
   in my sort methods.
 * Code for list method tests from Cam Moore.
 * 
 * @author kelseykato
 */
public class SortableListTest {
  private Integer[] ints;
  private IntegerComparator compare;
  private SortableList<Integer> integerArray;
  private SortableList<Integer> toSortArray;
  private SortableList<Integer> toSortArray2;
  
  /** Sets up the array lists. */
  @Before
  public void setUp() {
    ints = new Integer[3];
    ints[0] = 1;
    ints[1] = 2;
    ints[2] = 3;
    
    integerArray = new SortableList<Integer>();
    for (int i = 0; i < ints.length; i++) {
      integerArray.add(i + 1);
    }  
    
    toSortArray = new SortableList<Integer>();
    for (int i = ints.length - 1; i > -1; i--) {
      toSortArray.add(ints[i]);
    }
    
    toSortArray2 = new SortableList<Integer>();
    toSortArray2.add(2);
    toSortArray2.add(1);
    toSortArray2.add(3);    
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#get(int)}.
   */
  @Test
  public void testGet() {
    assertTrue("Wrong Get", ints[0].equals(integerArray.get(0)));
    assertTrue("Wrong Get", ints[1].equals(integerArray.get(1)));
    assertTrue("Wrong Get", ints[2].equals(integerArray.get(2)));
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#set(int, edu.ics211.h01.Beer)}.
   */
  @Test
  public void testSet() {
    integerArray.set(0, ints[1]);
    assertTrue("Wrong Get", ints[1].equals(integerArray.get(0)));
    assertTrue("Wrong Get", ints[1].equals(integerArray.get(1)));
    assertTrue("Wrong Get", ints[2].equals(integerArray.get(2)));
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#indexOf(java.lang.Object)}.
   */
  @Test
  public void testIndexOf() {
    Integer i = 4;
    assertEquals("Shouldn't find i", integerArray.indexOf(i), -1);
    assertEquals("Shouldn't find i", integerArray.indexOf(ints[0]), 0);
    assertEquals("Shouldn't find i", integerArray.indexOf(ints[1]), 1);
    assertEquals("Shouldn't find i", integerArray.indexOf(ints[2]), 2);
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#size()}.
   */
  @Test
  public void testSize() {
    assertEquals("Wrong size want 3", integerArray.size(), 3);
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#add(edu.ics211.h01.Beer)}.
   */
  @Test
  public void testAddEnd() {
    Integer i = 4;
    assertTrue(integerArray.add(i));
    assertEquals("Wrong size want 4", integerArray.size(), 4);
    assertTrue("Wrong Get", i.equals(integerArray.get(3)));
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#add(int, edu.ics211.h01.Beer)}.
   */
  @Test
  public void testAddMiddle() {
    Integer i = 4;
    integerArray.add(1, i);
    assertEquals("Wrong size want 4", integerArray.size(), 4);
    assertTrue("Wrong Get", i.equals(integerArray.get(1)));
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#remove(int)}.
   */
  @Test
  public void testRemove() {
    try {
      integerArray.remove(-1);
      fail("Should throw exception");
    } catch (Exception e) {
      // expected
    }
    assertEquals("Wrong size want 3", integerArray.size(), 3);
    integerArray.remove(0);
    assertEquals("Wrong size want 2", integerArray.size(), 2);
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#bubbleSort(compare)}.
   */
  @Test
  public void testBubbleSort() {
    compare = new IntegerComparator();
    
    toSortArray.bubbleSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray.get(i)));
    }
    
    toSortArray2.bubbleSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray2.get(i)));
    }

  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#insertionSort(compare)}.
   */
  @Test
  public void testInsertionSort() {
    compare = new IntegerComparator();
    
    toSortArray.insertionSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray.get(i)));
    }
    
    toSortArray2.insertionSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray2.get(i)));
    }
  }
  
  /**
   * Test method for {@link edu.ics211.h04.SortableList#selectionSort(compare)}.
   */
  @Test
  public void testSelectionSort() {
    compare = new IntegerComparator();
    
    toSortArray.selectionSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray.get(i)));
    }
    
    toSortArray2.insertionSort(compare);
    for (int i = 0; i < ints.length; i++) {
      assertTrue("Did not sort", ints[i].equals(toSortArray2.get(i)));
    }
    
  }

}
