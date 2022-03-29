import java.util.*;


public class BasicDoubleLinkedList<T> implements Iterable<T>{


	private int listSize;
	public Node<T> listStart;
	public Node<T> listEnd;



	public BasicDoubleLinkedList() {
		listEnd = null;
		listStart = null;
		listSize = 0;
	}

	public void addToFront(T toAdd) {
		if(listStart == null) {
			listStart = new Node( null, toAdd, null);
			listEnd = listStart;
		}
		else {

			listStart = new Node( null, toAdd, listStart);
			listStart.next.prev = listStart;
		}
		listSize++;

	}

	public void addToEnd(T toAdd) {
		if(listStart == null) {
			listEnd = new Node(null, toAdd, null);
			listStart = listEnd;

		}
		else {
			listEnd = new Node(listEnd, toAdd, null);
			listEnd.prev.next = listEnd;

		}
		listSize++;
	}

	public int getSize() {

		return listSize;
	}
	public T getLast() {

		return listEnd.data;
	}


	public T getFirst() {

		return  listStart.data;
	}



	public ArrayList<T> toArrayList() {

		if(listStart == null) {
			return new ArrayList<T>();
		}
		Node currNode = listStart;
		ArrayList<T> toReturn = new ArrayList<T>();

		for (T mine : this) {

			toReturn.add(mine);

		}
		return toReturn;
	}




	public T retrieveFirstElement() {
		if(listStart == null)
			return null;

		else if((listStart==listEnd)&&listSize == 1) {
			T toRemove =listStart.data;
			listStart = null;
			listEnd = null;
			listSize--;
			return toRemove;
		}

		T toRemove = listStart.data;
		listStart = listStart.next;
		listStart.prev=null;

		listSize--;
		return (T) toRemove;
	}

	public  T retrieveLastElement() {
		if(listEnd == null)
			return null;

		else if((listStart==listEnd)&&listSize == 1) {
			T toRemove =listEnd.data;
			listStart = null;
			listEnd = null;
			listSize--;
			return toRemove;
		}

		T toRemove =listEnd.data;
		listEnd = listEnd.prev;
		listEnd.next = null;

		listSize--;
		return  toRemove;
	}

	public void remove(T a, Comparator<T> comparator) {
		if(listSize == 0)
			throw new NoSuchElementException();
		else if(comparator.compare(listStart.data, a)==0)
			retrieveFirstElement();

		else if(comparator.compare(listEnd.data, a)==0)
			retrieveLastElement();

		else {

			Node currNode = listStart;

			while(comparator.compare((T)currNode.data, a)!=0){
				currNode = currNode.next;

			}
			if(currNode == null){
				throw new NoSuchElementException();
			}			
			currNode.prev.next = currNode.next;
			currNode.next.prev= currNode.prev;

			currNode.prev = null;
			currNode.next = null;
			listSize--;
		}

	}


	private class Node<T>{

		private T data;
		private Node<T> next;
		private Node<T> prev;


		public Node(Node prev, T data, Node next) {
			this.data = data;
			this.prev =prev;
			this.next =next;

		}

	}


	public ListIterator<T> iterator() {

		return new ListIterator <T>() {
			private Node<T> iteratorLoc = listStart;


			public void add(T toAdd){
				System.out.println(iteratorLoc.data);
				Node toInsert =new Node(iteratorLoc.prev, toAdd,iteratorLoc);
				iteratorLoc.prev.next = toInsert;
				iteratorLoc.prev = toInsert;
				listSize++;
			}


			public boolean hasNext() {
				return iteratorLoc != null;
			}


			public boolean hasPrevious() {
				if((iteratorLoc==null))
					return true; 
				return (listStart!=null)&&(iteratorLoc.prev != null);

			}


			public T next() {

				if(hasNext() == false)
					throw new NoSuchElementException();

				T toReturn = (T)iteratorLoc.data;
				iteratorLoc = iteratorLoc.next;


				return toReturn;
			}


			public int nextIndex() throws  UnsupportedOperationException{
				throw new UnsupportedOperationException();
			}


			public T previous() {
				if(hasPrevious() == false)
					throw new NoSuchElementException();

				else if((iteratorLoc==null)) {
					iteratorLoc = listEnd;
				}

				else 
					iteratorLoc = iteratorLoc.prev;

				return (T)iteratorLoc.data;
			}


			public int previousIndex() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
			}


			public void remove() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();

			}


			public void set(T e) throws UnsupportedOperationException{
				throw new UnsupportedOperationException();

			}
			public T getData() {

				return (T) iteratorLoc.data;

			}


		};



	}

}
