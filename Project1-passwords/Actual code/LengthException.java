/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if shorter than 6 characters
 * 
 */
public class LengthException extends Exception {
	public LengthException(String string) {
		super(string);
	}
}
