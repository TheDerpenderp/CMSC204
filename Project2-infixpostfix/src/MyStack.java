import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{

	private T[] theStack;
	private int maxSize;
	
	
	public MyStack() {
		theStack =(T[]) new Object[10];
		
		maxSize = 0;
	}
	
	
	public MyStack(int size) {
		theStack =(T[]) new Object[size];
		
		maxSize = 0;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return maxSize==0;
	}

	
	public boolean isFull() {
		// TODO Auto-generated method stub
		return maxSize==theStack.length;
	}


	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T toReturn = null;
		
		toReturn = theStack[maxSize-1];
		theStack[maxSize-1]=null;
		maxSize--;
		
		return toReturn;
	}

	
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return theStack[maxSize-1];
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return maxSize;
	}

	

	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		theStack[maxSize]=e;
		maxSize++;
		
		
		return true;
	}

	
	public String toString() {
		String toRet = "";
		for(int i = 0; i<maxSize; i++)
			toRet+=theStack[i];
		
		return toRet;
	}
	
	
	
	public String toString(String delimiter) {
		String toRet = "";
		for(int i = 0; i<maxSize-1; i++)
			toRet+=theStack[i]+delimiter;
		
		toRet+=theStack[maxSize-1];
		
		return toRet;
	}

	
	public void fill(ArrayList<T> list) throws StackOverflowException {
		ArrayList<T> copy = new ArrayList<T>();
		for(T ele: list)
			copy.add(ele);
		
		for(T ele: copy) {
			if(isFull()) {
				throw new StackOverflowException();
			}
			theStack[maxSize] = ele;
			maxSize++;
		}
		
		
	}


}
