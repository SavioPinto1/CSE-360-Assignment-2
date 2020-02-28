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

	
	// Setting count to 0 and list to 10 spaces of use
	public SimpleList() 
	{
		list = new int[10];
		count = 0;
	}

	
	// Add a new integer to the beginning of the list at index = 0
	// Moves the other integers over to the right and if the list is full,
	// it removes the last element off the list and increments count after procedure
	public void add(int newInt) 
	{
		// Removing one from count if it goes over 10 after each addition
		if (count == 10) 
		{
			count--;
		}
		
		// Loop goes through each value increasing by one index value
		for (int firstLoop = count; firstLoop > 0; firstLoop--) 
		{
			list[firstLoop] = list[firstLoop - 1];
		}
		
		list[0] = newInt;
		
		// Increases count by one if limit of 10 is not reached
		if (count != 10) 
		{
			count++;
		}
	}

	
	// Removes the selected parameter from the list and other values
	// in the list are moved down while adjusting the count value
	public void remove(int newInt) 
	{
		
		int lengthOfList = 9;
		
		// Sets the count to 0 in case count becomes out of bounds
		if (count == -1) 
		{
			count = 0;
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

	
	// Returns the number of elements stored in the list
	public int count() 
	{
		return count;
	}

	
	// Returns the list in as a String with spaced between each value
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

	
	// Searches for the location of the specific parameter in the list
	// If parameter is not present, a -1 is returned
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
}