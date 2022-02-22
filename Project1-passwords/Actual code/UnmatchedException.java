/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if passwords do not match
 * 
 */
public class UnmatchedException extends Exception {

	public UnmatchedException() {
		super();
	}
	
	public UnmatchedException(String string) {
		super(string);
	}
}
