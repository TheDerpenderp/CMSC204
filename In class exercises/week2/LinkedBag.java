
public final class LinkedBag<T> implements BagInterface<T>{
	private int size;
	private node head;
	private node endOfList;

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public boolean add(T newEntry) {
		if(head == null) {
			head = new node(newEntry);
			endOfList = head;
			size++;
			return true;
		}
		size++;
		endOfList.next = new node(newEntry);
		endOfList = endOfList.next;
		return true;
	}

	@Override
	public T remove() {
		if(head == null)
			return null;
		T toReturn;
		size--;
		if(head.data.equals(endOfList.data)) {
			toReturn = head.data;
			head = null;
			endOfList = null;
			return toReturn;

		}

		//traverse to the end of the linked list
		node curr = head;
		while(curr.next.data !=endOfList.data)
			curr = curr.next;

		toReturn = endOfList.data;

		endOfList = curr;
		endOfList.next.data = null;
		endOfList.next = null;
		return toReturn;
	}

	@Override
	public boolean remove(Object anEntry) {
		if(endOfList.data.equals(anEntry))
			return remove()!=null;

		node curr = head;
		while(curr.data !=endOfList.data) {
			if(curr.data.equals(anEntry)) {
				node supportNode = curr.next;
				curr.next.next = curr.next;
				supportNode.next = null;
				size--;
				
				return true;
			}
		}
		return false;
	}
	@Override
	public void clear() {
		//we really love the garbage collector
		head = null;
		endOfList = null;

	}

	@Override
	public int getFrequencyOf(Object anEntry) {
		int toret = 0;
		if(endOfList.data.equals(anEntry))
			toret++;

		node curr = head;
		while(curr.data !=endOfList.data) {
			if(curr.data.equals(anEntry)) {
				toret++;
			}
			curr = curr.next;
		}
		return toret;
	}

	@Override
	public boolean contains(Object anEntry) {
		if(endOfList.data.equals(anEntry))
			return true;

		node curr = head;
		while(curr.data !=endOfList.data) {
			if(curr.data.equals(anEntry)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		T[] toRet = (T[]) new Object[size];
		node curr = head;
		int count = 0;
		while(curr.data !=endOfList.data) {
			toRet[count]= curr.data;
			count++;
			curr = curr.next;
		}
		toRet[count+1]= curr.data;
		return toRet;
	}

	private class node{

		private node next;
		private T data;

		public node(T data) {
			next = null;
			this.data = data;
		}

	}


}
