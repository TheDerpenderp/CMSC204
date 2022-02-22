/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if is valid, but has 6-9 characters
 * 
 */
public class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		super();
	}

	public WeakPasswordException(String string) {
		super(string);
	}
}
