/*
 * 
 *@author Konstantin Tomashevsky 
 * exception thrown if no uppercase letter 
 * 
 */
public class NoUpperAlphaException extends Exception {

	public NoUpperAlphaException() {
		super();
	}

	public NoUpperAlphaException(String string) {
		super(string);
	}


}
