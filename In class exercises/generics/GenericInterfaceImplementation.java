
public class GenericInterfaceImplementation<T> implements GenericInterface<T>{

	private T first;
	private T second;
	
	
	public GenericInterfaceImplementation(T first, T second) {
		this.first = first;
		this.second = second;
	}

	
	public T getFirst() {
		
		return first;
	}

	
	public T getSecond() {
		
		return second;
	}


	public void changeOrder() {
		T temp = first;
		first = second;
		second = temp;
		
	}

}
