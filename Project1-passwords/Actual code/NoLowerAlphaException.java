/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if no lowercase letter
 * 
 */
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super();
	}

	public NoLowerAlphaException(String string) {
		super(string);
	}
}
