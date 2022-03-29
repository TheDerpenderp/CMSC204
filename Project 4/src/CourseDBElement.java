
public class CourseDBElement implements Comparable{

	public String CourseID;
	public int CRN;
	public int numCredits;
	public String roomNum;
	public String instructorName;
	
	public CourseDBElement(String CourseID,int CRN,int numCredits,String roomNum,String instructorName) {
		this.CourseID = CourseID;
		this.CRN = CRN;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
		
	}
	
	
	public CourseDBElement() {
		
	}


	public int compareTo(Object element) {
		
		return this.CRN-((CourseDBElement)element).CRN;
	}


	public int getCRN() {
		return CRN;
	}
	
	public String getID() {
		
		return CourseID;
		
	}


	public void setCRN(int parseInt) {
		CRN = parseInt;
		
	}


	public String getRoomNum() {
		
		return roomNum;
	}

}
