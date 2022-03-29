
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 A class that implements the ADT list by using a resizable array and
 gives it an iterator.
 */
public class BasicArrayList<T>  implements ListWithIteratorInterface<T>
{
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public BasicArrayList()
	{
		this(DEFAULT_CAPACITY);
	} 

	public BasicArrayList(int initialCapacity)
	{      
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
	} 

	public void add(T newEntry)
	{
		add(numberOfEntries + 1, newEntry);
	} 

	public void add(int newPosition, T newEntry)
	{
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			if (newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	} 

	public T remove(int givenPosition)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			T result = list[givenPosition]; // Get entry to be removed

			// Move subsequent entries towards entry to be removed,
			// unless it is last in list
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			list[numberOfEntries] = null;
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	} 

	public void clear()
	{

		// Clear entries but retain array; no need to create a new array
		for (int index = 1; index <= numberOfEntries; index++) // Loop is part of Q4
			list[index] = null;

		numberOfEntries = 0;
	} 

	public T replace(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			// Assertion: The list is not empty
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} 

	public T getEntry(int givenPosition)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			// Assertion: The list is not empty
			return list[givenPosition];
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray()
	{      
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++)
		{
			result[index] = list[index + 1];
		} // end for

		return result;
	} // end toArray

	public boolean contains(T anEntry)
	{
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries))
		{
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} // end while

		return found;
	} // end contains

	public int getLength()
	{
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty

	// Doubles the capacity of the array list if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity()
	{
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity)
		{
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		} // end if
	} // end ensureCapacity

	// Prepares a space for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	//               numberOfEntries is list's length before addition;
	//               checkIntegrity has been called.
	private void makeRoom(int newPosition)
	{
		// Assertion: (newPosition >= 1) && (newPosition <= numberOfEntries + 1)
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;

		// Move each entry to next higher index, starting at end of
		// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
	}  // end makeRoom

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	//               numberOfEntries is list's length before removal;
	//               checkIntegrity has been called.
	private void removeGap(int givenPosition)
	{
		// Assertion: (givenPosition >= 1) && (givenPosition < numberOfEntries)

		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;

		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	} // end removeGap



	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity)
	{
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a list " +
					"whose capacity exceeds " +
					"allowed maximum.");
	} // end checkCapacity


	public Iterator<T> iterator() {

		return new CustIterator();
	}


	public Iterator<T> getIterator() {

		return new CustIterator();
	}


	private class CustIterator<T> implements Iterator<T>{

		private int position;
		private int size;
		private boolean lastCalledRem;
		private BasicArrayList<T> myData;
		//seems much easier to copy and start moving around

		public CustIterator(){

			position = -1;
			size = getLength();
			myData = new BasicArrayList(getLength());
			//copy data over
			lastCalledRem = true;
			T[] array = (T[]) toArray();
			
			for(T toAdd: array) {
				myData.add(toAdd);
			}
			
		}


		public boolean hasNext() {

			return position < size;
		}


		public T next() {
			if(hasNext())
				return (T) getEntry(++position);
			lastCalledRem = false;
			return  null;//???
		}
		public void remove() {
			if(lastCalledRem) {
				//throw some exception
				
			}
			
			myData.remove(position--);
			
			lastCalledRem = false;
			
			
			
		}



	}




} 

