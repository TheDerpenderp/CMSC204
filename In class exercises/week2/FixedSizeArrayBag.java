
public final class  FixedSizeArrayBag<T> implements BagInterface<T>{

	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY =100;
	
	public FixedSizeArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public FixedSizeArrayBag(int size) {
		//T[] tempbag = (T[]) new Object[size]
		//bag = tempbag
		//not sure why its needed, since the user won't be able to get direct access to the bag anyway
		if(size>MAX_CAPACITY)
			return;
		numberOfEntries=0;
		bag = (T[]) new Object[size];
	}

	@Override
	public int getCurrentSize() {
		
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		
		return numberOfEntries==0;
	}

	@Override
	public boolean add(T newEntry) {
		if(bag.length>=numberOfEntries) {
			return false;
		}
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}

	@Override
	public T remove() {
		if(0==numberOfEntries) {
			return null;
		}
		T toReturn = bag[numberOfEntries];
		numberOfEntries--;
		return toReturn;
		
	}

	//get specific index
	public boolean remove(T anEntry) {
		int index = 0;
		for (int i= 0;  i< numberOfEntries; i++) {
			if(anEntry.equals(bag[i])) {
				index = i;
				break;
				
			}
		}
		
		for (int i= index;  i< numberOfEntries-1; i++) {
			
			bag[i] = bag[i+1];
				
				
			
		}
		numberOfEntries--;
		return false;
	}

	@Override
	public void clear() {
		//the garbage collector is very cool;
		bag =  (T[]) new Object[bag.length];
	
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int toreturn = 0;
		for(int i = 0;i<numberOfEntries;i++) {
			if(bag[i].equals(anEntry))
				toreturn++;
			
		}
		return toreturn;
	}

	@Override
	public boolean contains(T anEntry) {
		for(int i = 0; i<numberOfEntries;i++) {
			
			if(bag[i].equals(anEntry))
			return true;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		T[] toReturn = (T[]) new Object[numberOfEntries];
		for(int i = 0; i<numberOfEntries;i++) {
			
			toReturn[i] = bag[i];
			
		}
		return toReturn;
	}
	
	
	//absolutly not sure why we need this as we only check once in the whole implementaion 
	private boolean isArrayFull() {
		return bag.length>=numberOfEntries;
		
		
		
	}

}
