import java.util.*;

public class SortedDoubleLinkedList<T>  extends BasicDoubleLinkedList<T>{

	private Comparator<T> theCompare;
	
	
	
	public SortedDoubleLinkedList(Comparator comparator) {
		super();
		theCompare = comparator;
	}

	public void addToEnd(T toAdd) {
		//not supported
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	public void addToFront(T toAdd) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		//not supported
	}

	public void add(T toAdd){
		
		if(getSize()==0) {
			super.addToFront(toAdd);
			return;
		}
		if(theCompare.compare(getFirst() , toAdd)>0){
			super.addToFront(toAdd);
			return;
		}
		if(theCompare.compare(getLast(), toAdd)<0) {
			super.addToEnd(toAdd);
			return;
		}
		
		ListIterator<T> iter = iterator();
		while((iter.hasNext()!=false)&&(theCompare.compare(iter.next(), toAdd)>0)) {
			
		}
		
		iter.add(toAdd);
	}
	
	
	
	
}
