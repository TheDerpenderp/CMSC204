
import java.io.IOException;
import java.util.*;


public class CourseDBStructure implements CourseDBStructureInterface{

	public LinkedList[] hashTable;
	public int sizeOfArray; 
	public Hashtable<String, LinkedList<CourseDBElement>[]> theData;


	public CourseDBStructure(int size) {

		int n = 0;
		int kn =0;
		boolean isPrime=true;
		
		while((kn<(size/1.5)||(isPrime==false))) {
		
			kn=4*n+3;
			//need to check if it is prime
			int temp =1;
			int num = 4*n+3;
			
			if((kn>(size/1.5))){
				for(int i=2;i<num/2;i++)
				{
					isPrime = true;
					temp=num%i;
					if(temp==0)
					{
						isPrime=false;
						break;
					}
				}
			}
			
			n++;

		}
		

		sizeOfArray = kn;
		hashTable = new LinkedList[kn];
	}

	public CourseDBStructure(String test, int size) {
		hashTable = new LinkedList[size];
		sizeOfArray = size;
	}


	public void add(CourseDBElement element) {
		int hashcode = ((element.CRN+"").hashCode())%sizeOfArray;

		if(hashTable[hashcode] == null) 
			hashTable[hashcode] = new LinkedList();
		if(!hashTable[hashcode].contains(element))
			hashTable[hashcode].add(element);


	}


	public CourseDBElement get(int crn) throws IOException {
		int hashcode = ((crn+"").hashCode())%sizeOfArray;
		if(hashTable[hashcode] == null) 
			throw new IOException();

		ListIterator h = hashTable[hashcode].listIterator();
		while(h.hasNext()) {
			CourseDBElement yes = (CourseDBElement) h.next();
			if(yes.getCRN() == crn)
				return yes;

		}

		return null;
	}


	public int getTableSize() {

		return sizeOfArray;
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> toReturn = new ArrayList<String>();

		for(LinkedList l: hashTable) {
			if(l != null) {
				for(Object cde: l.toArray()) {
					CourseDBElement yee = (CourseDBElement)cde;
					System.out.println("\nCourse:"+yee.CourseID+ " CRN:"+yee.CRN +" Credits:"+yee.numCredits+" Instructor:"+yee.instructorName+" Room:"+yee.roomNum);
					toReturn.add(("\nCourse:"+yee.CourseID+ " CRN:"+yee.CRN +" Credits:"+yee.numCredits+" Instructor:"+yee.instructorName+" Room:"+yee.roomNum));
				}
			}


		}
		return toReturn;

	}




}
