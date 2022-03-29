import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure theStruct;

	public CourseDBManager() {

		theStruct = new CourseDBStructure(15);

	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		theStruct.add(new CourseDBElement(id, crn, credits, roomNum, instructor));

	}

	@Override
	public CourseDBElement get(int crn) {

		try {
			return theStruct.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanFile=null;
		try{
			scanFile=new Scanner(input);
		}catch(FileNotFoundException e){
			
		}
		while(scanFile.hasNextLine()) {

			add(scanFile.next(),scanFile.nextInt(),scanFile.nextInt(),scanFile.next(),scanFile.nextLine());
		}

	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> toReturn = new ArrayList<String>();

		for(LinkedList l: theStruct.hashTable) {
			if(l != null) {
				for(Object cde: l.toArray()) {
					CourseDBElement converted = (CourseDBElement)cde;
					
					toReturn.add(("\nCourse:"+converted.CourseID+ " CRN:"+converted.CRN +" Credits:"+converted.numCredits+" Instructor:"+converted.instructorName+" Room:"+converted.roomNum));
				}
			}


		}
		return toReturn;

	}

}
