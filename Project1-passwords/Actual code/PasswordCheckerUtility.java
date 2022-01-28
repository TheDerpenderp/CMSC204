import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	//the constructor
	public PasswordCheckerUtility() {
		
		
		
	}
    public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		isValidLength​(password);
    	hasUpperAlpha​(password);
    	hasLowerAlpha​(password);
    	hasDigit​(password);
    	hasSpecialChar​(password);
    	NoSameCharInSequence​(password);
    	
		return true;
	}

	public static boolean isWeakPassword(String string) throws WeakPasswordException{
		boolean valid = false;
		try {
			valid = isValidPassword​(string);
		} catch (Exception e) {
			return false;
		}
		if(valid&&hasBetweenSixAndNineChars​(string)){
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
		}		
		return false;
	}

    
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		//allrighty time for a big loopo
		ArrayList<String> toReturn = new ArrayList<String>() ;
		
		for(String s: passwords) {
			String toPut = "";
			toPut = s;
			toPut+=" -> ";
			try {
				isValidPassword​(s);
			} catch (Exception e) {
				toPut+= e.getMessage();
				 toReturn.add(toPut);
			}
			/* catch (LengthException e) {
				
			
			}catch (NoUpperAlphaException e) {
				
				
			} catch (NoLowerAlphaException e) {
				
			
			} catch (NoDigitException e) {
			
				
			} catch (NoSpecialCharacterException e) {
			
				
			} catch (InvalidSequenceException e) {
				
			}
			*/
			
		}
		
		
		
		return toReturn;
		
		
	}

	


	//the other checks, other than the three main

	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException{
		if(password.length()<passwordConfirm.length()) {
			throw new UnmatchedException("Passwords do not match");
		}
		else if (password.length()>passwordConfirm.length()) {
			
			throw new UnmatchedException("Passwords do not match");
		}
		
		for(int i =0;i<password.length();i++) {
			if(password.charAt(i)!= passwordConfirm.charAt(i))
				throw new UnmatchedException("Passwords do not match");
			
		}
		
		
	}
	
	
	//assuming same as the first without the throw, only return
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) {
		if(password.length()<passwordConfirm.length()) {
			return false;
		}
		else if (password.length()>passwordConfirm.length()) {
			
			return false;
		}
		
		for(int i =0;i<password.length();i++) {
			if(password.charAt(i)!= passwordConfirm.charAt(i))
				return false;
			
		}
		
		return true;
	}
	
	//must be at least 6 characters long
	public static boolean isValidLength​(String password) throws LengthException{
		if(password.length()>=6)
			return true;
		throw new LengthException("The password must be at least 6 characters long");
	}

	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException{
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
			
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException{
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
			
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		
	}
	
	public static boolean hasDigit​(String password) throws NoDigitException{
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
			
		}
		throw new NoDigitException("The password must contain at least one digit");
		
		
	}
	
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()) {
			return true;
			
		}
		throw new NoSpecialCharacterException("The password must contain at least one special character");
		
		
	}
	
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException{
		//first plan of action, go over everything in the string, if curr letter is equalk to the previous, then we shall throw the error
		//relies on the fact that it is longer than 2 characters
		boolean hasBeenTwo = false;
		for(int i = 1;i<password.length();i++) {
			if(hasBeenTwo)
				if(password.charAt(i-1) == password.charAt(i)) {
					throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
				}
				else {
					hasBeenTwo = false;
				}
			
			if(password.charAt(i-1) ==password.charAt(i))
				hasBeenTwo = true;
			
		}
		
		
		
		return true;
	}
	
	//does what it says, should make check if its between 6-9 characters long
	public static boolean hasBetweenSixAndNineChars​(String password) {
		
		return ((password.length()>=6)&&(password.length()<=9));
		
	}

}
