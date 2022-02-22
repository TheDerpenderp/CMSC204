import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{

	private node<T> theHead;
	private node<T> theTail;
	private int maxSize;
	private int maxCap;
	
	public MyQueue() {
		maxSize = 0;
	
		maxCap = 10;
	}
	
	
	public MyQueue(int size) {
		maxSize = 0;
	
		maxCap = size;
		
	}

	
	public boolean isEmpty() {
		
		return maxSize==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return maxSize==maxCap;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		System.out.println(maxSize);
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T toRet = null;
		if(maxSize==1) {
			toRet = theHead.data;
			
			theHead = null;
			theTail = null;
			maxSize--;
			return toRet;
		}
		toRet = theHead.data;
		theHead = theHead.next;
		maxSize--;
		return toRet;
	}


	public int size() {
		
		return maxSize;
	}

	
	public boolean enqueue(T e) throws QueueOverflowException {
		
		if(isFull()) {
			throw new QueueOverflowException();
		}
		if(theHead == null) {
			theHead = new node<T>();	
			
			
			theHead.next = null;
			theHead.data = e;
			
			theTail = theHead;
			
			maxSize++;
			return true;
		}
		maxSize++;
		
		theTail.next = new node<T>();
		theTail.next.data = e;
		theTail.next.next = null;
		theTail = theTail.next;
		
		return true;
	}

   public String toString() {
		String toRet = "";
		
		node curr = theHead;
		while (curr !=null) {
			toRet += curr.data;
			
			curr = curr.next;
		}
		
		
		return toRet;
	}
	public String toString(String delimiter) {
		String toRet = "";
		
		node curr = theHead;
		while (curr !=null) {
			toRet += curr.data+ delimiter;
			
			curr = curr.next;
		}
		toRet = toRet.substring(0,toRet.length()-1);
		
		return toRet;
	}

	@Override
	public void fill(ArrayList<T> list) {
		maxCap = list.size();
		while(maxSize!=maxCap) {
			
			try {
				enqueue(list.get(maxSize));
			} catch (QueueOverflowException e) {
				
				
			}
			
		}
		
	}
	
	private class node<T>{
		
		private node next;
		private T data;
		
		public node(){
			data = null;
			next=null;
		}
			
		
		
	}
	
	
	
	
	
	
	
	
	

}
