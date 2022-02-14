
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords ;
	private String UpperTest;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		String[] pass = {"AAAAA", "aaaaaaaaaa", "AAAAAAA", "Aabb129#", "AAAAAAAAAA", "AAAAAAAAAA", "Aa123$fkw$jsl"
				};
		
		passwords.addAll(Arrays.asList(pass));
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidLength(passwords.get(0)));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("threw a lengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw length exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwords.get(1)));
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("threw a NoUpperAlphaExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw NoUpperAlphaexception",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwords.get(2)));
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw NoLowerAlphaexception",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword(passwords.get(3)));
			assertTrue("Did not throw weakPasswordException",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("threw a WeakPasswordException",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw WeakPasswordException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(passwords.get(4)));
			assertTrue("Did not throw InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("threw a InvalidSequenceException",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasDigit(passwords.get(5)));
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("threw a NoDigitException",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("did not throw NoDigitException",false);
		}
	}
	
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(6)));
			assertTrue("Did not throw exception",true);
		}
		
		catch(Exception e)
		{
			fail("not valid");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		passwords.remove(6);
		passwords.remove(3);
		try{
			
			assertEquals(PasswordCheckerUtility.getInvalidPasswords(passwords).isEmpty(),false);
			assertTrue("it did indeed word",true);
			
		}
		
		catch(Exception e)
		{
			fail("not valid");
		}
	}
	
}
