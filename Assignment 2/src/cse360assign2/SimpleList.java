// -------------------------------------------------------------------------------------
// Author : Savio Pinto
// Class ID : 420
// Assignment # : 2
// Description : Creation and editing features of a list containing 10 integer values.
//				Editing includes removal, addition, count, toString, and search methods.
// -------------------------------------------------------------------------------------

package cse360assign2;

public class SimpleList 
{

	// Creating private variables of count and list
	private int[] list;
	private int count;

	
	/*
	 * Constructor : Setting count to 0 and list to ten spaces of use
	 */
	public SimpleList() 
	{
		list = new int[10];
		count = 0;
	}

	/**
	 * Add a new integer to the beginning of the list at index = 0
	 * Moves the other integers over to the right and if the list is full,
	 * it removes the last element off the list and increments count after procedure
	 * NEW : If list was full, size of list increases by 50 percent to accommodate
	 * 
	 * @oaram newInt the integer to be added into the list
	 */
	public void add(int newInt) 
	{
		// To increase list size if exceeding ten limit by fifty percent
		if (count == list.length) 
		{
			int previousCount = count - 1;
			int[] newerList = new int[count + count / 2];
			
			for (int secondLoop = 0; secondLoop <= previousCount; secondLoop++) 
			{
				newerList[secondLoop] = list[secondLoop];
			}
			
			list = newerList;
		}
		
		// Loop goes through each value increasing by one index value
		for (int firstLoop = count; firstLoop > 0; firstLoop--) 
		{
			list[firstLoop] = list[firstLoop - 1];
		}
		
		// Integer added to beginning of list and count increases by one
		list[0] = newInt;
		count++;
	}

	
	/**
	 * Removes the selected parameter from the list and other values
	 * in the list are moved down while adjusting the count value
	 * 
	 * @param newInt the integer to be removed from the list
	 */
	public void remove(int newInt) 
	{
		
		int lengthOfList = 9;
		
		// Sets the count to 0 in case count becomes out of bounds
		if (count == -1) 
		{
			count = 0;
		}
		
		// If list is greater than twenty five percent of blanks, the list shrinks
		if (count < list.length - list.length / 4) 
		{
			int previousCount = count - 1;
			int [] newerList = new int[list.length - list.length / 4];
			
			for (int secondLoop = 0; secondLoop <= previousCount; secondLoop++) 
			{
				newerList[secondLoop] = list[secondLoop];
			}
			
			list = newerList;
		}
		
		// Checks if value is inside of the loop, if so it decreases count
		// and goes to the inner loop to check position of value in loop and remove
		// Proceeding values get moved to the left and replaced values = 0 at the right
		for (int removeLoop = 0; removeLoop < lengthOfList; removeLoop++) 
		{
			if (list[removeLoop] == newInt) 
			{
				count--;
				
				for (int innerLoop = removeLoop; innerLoop < list.length - 1; innerLoop++) 
				{
					list[innerLoop] = list[innerLoop + 1];
					lengthOfList = 0;
				}
				
				// Sets the value of unmoved integer to 0 to be placed on the right
				list[count] = 0;
			}
		}
	}
	
	
	/**
	 * Returns the number of elements stored in the list
	 * 
	 * @return count  returns the number of stored elements in the list
	 */
	public int count() 
	{
		return count;
	}
	
	 
	/**
	 * Function to return the list in as a String with spaced between each value
	 * 
	 * @return fullList  all integers within the returned string
	 */
	public String toString() 
	{
		String fullList = "";
		
		if (count != 0) 
		{
			// Adds the first value at index 0 to the list
			fullList = fullList + list[0];
			
			// Adds a space before the next values starting at index 0 till end of count
			for (int firstLoop = 1; firstLoop < count; firstLoop++) 
			{
				fullList = fullList + " " + list[firstLoop];
			}
		}
		
		// Returns the full string without a space at the end
		return fullList;
	}
	
	
	/**
	 * Function to search for the location of the specific parameter in the list
	 * If parameter is not present, a -1 is returned
	 * 
	 * @param searchValue  value being searched in list
	 * @return -1  value returned when full list is empty
	 * @return fullListIndex  indexValue of search value parameter
	 */
	public int search(int searchValue) 
	{
		int multipleValues = 0;
		int fullListIndex = 10;
		
		// Checks if value 
		for (int firstLoop = 0; firstLoop < fullListIndex; firstLoop++) 
		{
			// returns index location of found parameter
			if (list[firstLoop] == searchValue) 
			{
				fullListIndex = multipleValues;
			}
			
			multipleValues++;
		}
		
		if (fullListIndex + 1 > count) 
		{
			// Returns -1 if not within the list after checking with count value
			return -1;
		} 
		else 
		{
			// Returns the index if within the list after checking with count value
			return fullListIndex;
		}
	}
	
	
	/**
	 * Function to return the first integer in list, and if not found, returns a -1
	 * 
	 * @return -1  value when the list is empty
	 * @return list[0]  returns the first index value
	 */
	public int first() 
	{
		// If the list is empty, returns a one
		if (count == 0) 
		{
			return -1;
		}
		
		// If not, returns the first value from the index
		return list[0];
	}
	
	
	/**
	 * Function to tell the the current number of possible locations in the list
	 * 
	 * @return list.length  shows current number of possible locations in list
	 */
	public int size() 
	{
		return list.length;
	}
	
	
	/**
	 * Function to give the last inputed integer at end of the list
	 * 
	 * @return list[count - 1]  returns last inputed integer at end of list
	 * @return -1  returns a -1 if no elements (n) in the list
	 */
	public int last()
	{
		if (count == 0)
		{
			return -1;
		}
		
		return list[count - 1];
	}
	
	
	/**
	 * Function to add a given integer to the end of the list
	 * 
	 * @param item  integer that will be added to end of the list
	 */
	public void append (int newInt) 
	{
		
		if (count == list.length) 
		{
			// Reduces count by one and adds 50 percent more into new list
			int previousCount = count - 1;
			int[] newerList = new int[count + count / 2];
			
			// Addition of all previous values from oldList to newerList 
			for (int firstLoop = 0; firstLoop <= previousCount; firstLoop++) 
			{
				newerList[firstLoop] = list[firstLoop];
			}
			
			// Size of the list variable updated with newerList size
			list = newerList;
		}
		
		// Increments count and adds the new integer to the end of the list
		list[count] = newInt;
		count++;
	}
	
}