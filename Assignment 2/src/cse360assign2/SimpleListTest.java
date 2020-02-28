// -------------------------------------------------------------
// Author : Savio Pinto
// Class ID : 420
// Assignment # : 2
// Description : Test of SimpleList methods using JUnit Tests
// -------------------------------------------------------------

package cse360assign2;

// Importing JUnit Tests
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimpleListTest 
{
	
	@Test
	public void testingConstructor() 
	{
		SimpleList test1 = new SimpleList();
		
		// Create list with values : 0 0 0 0 0 0 0 0 0 0
		
		// assertNull(test1);
		assertEquals(0, test1.count());
		assertEquals("", test1.toString());
	}

	@Test
	public void testAdd() 
	{
		SimpleList test1 = new SimpleList();
		
		// Initial Test of 5 Numbers = 6 7 8 9 10
		test1.add(10);
		test1.add(9);
		test1.add(8);
		test1.add(7);
		test1.add(6);
		
		assertEquals("6 7 8 9 10", test1.toString());
		
		// Full List Test = 1 2 3 4 5 6 7 8 9 10
		test1.add(5);
		test1.add(4);
		test1.add(3);
		test1.add(2);
		test1.add(1);
		
		// Modified Full List Test = 15 14 13 12 11 10 9 8 7 6
		test1.add(11);
		test1.add(12);
		test1.add(13);
		test1.add(14);
		test1.add(15);
		
		assertTrue(test1.toString().equals("15 14 13 12 11 1 2 3 4 5"));
		assertFalse(test1.toString().equals("1 2 3 4 5 21 12 13 14 15"));
	}
	
	@Test
	public void testRemove() 
	{
		SimpleList test2 = new SimpleList();
		
		// Full List Test = 1 2 3 4 5 6 7 8 9 10
		test2.add(10);
		test2.add(9);
		test2.add(8);
		test2.add(7);
		test2.add(6);
		test2.add(5);
		test2.add(4);
		test2.add(3);
		test2.add(2);
		test2.add(1);
		
		// Full List Remove = 2 3 4 6 7 9 10 0 0 0	
		test2.remove(1);
		test2.remove(5);
		test2.remove(8);
		
		assertFalse(test2.toString().equals("2 3 4 6 7 9 10 0 0 0"));
		assertTrue(test2.toString().equals("2 3 4 6 7 9 10"));
	}
	
	@Test
	public void testCount() 
	{
		SimpleList test3 = new SimpleList();
		
		// Count list Test = 60 50 40 30 20 10 0 0 0 0
		test3.add(10);
		test3.add(20);
		test3.add(30);
		test3.add(40);
		test3.add(50);
		test3.add(60);
		
		assertEquals(6, test3.count());		// Check if 6 values present in the list - Result = TRUE
		assertNotEquals(5, test3.count());	// Checks if not only 5 values present in the list - Result = TRUE
	}
	
	@Test
	public void testToString() 
	{
		SimpleList test4 = new SimpleList();
		
		// toString List Test = 5 4 3 2 1
		test4.add(5);
		test4.add(4);
		test4.add(3);
		test4.add(2);
		test4.add(1);
		
		assertFalse(test4.toString().equals("1 2 3 4 5 0 0 0 0 0"));
		assertTrue(test4.toString().equals("1 2 3 4 5"));
	}
	
	@Test
	public void testSearch() 
	{
		SimpleList test5 = new SimpleList();
		
		// Full List Search Test = 1 2 3 4 5 6 7 8 9 10
		test5.add(10);
		test5.add(9);
		test5.add(8);
		test5.add(7);
		test5.add(6);
		test5.add(5);
		test5.add(4);
		test5.add(3);
		test5.add(2);
		test5.add(1);
		
		assertEquals(3, test5.search(4));		// Searched for integer 4 at index of 3 -  Result = TRUE
		assertNotEquals(8, test5.search(8));	// Searched for integer 8 at index of 8 (Supposedly False) -  Result = TRUE
	}
}