
public class GenericInterfaceDriver {

	public static void main(String[] args) {
		
		GenericInterfaceImplementation<Integer> myImp = new GenericInterfaceImplementation<Integer>(1,2);
		myImp.changeOrder();
		System.out.println("First: "+ myImp.getFirst() +"\nSecond: "+myImp.getSecond());
		
		
	}

}
