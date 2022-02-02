/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if has more than 2 of the same character in sequence 
 * 
 */
public class InvalidSequenceException extends Exception {

	public InvalidSequenceException() {
		super();
	}
	public InvalidSequenceException(String string) {
		super(string);
	}

}
