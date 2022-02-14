import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook gTester;
	
	
	@BeforeEach
	public void setUp()  {
		
		gTester = new GradeBook(10);
		gTester.addScore(80);
		gTester.addScore(93);
		gTester.addScore(84);
		gTester.addScore(60);
		
	}

	@AfterEach
	public void tearDown()  {
		gTester =null;
		
	}
	@Test
	public void addScoreTest() {
		assertTrue(gTester.toString().equals("80.0 93.0 84.0 60.0 "));
		assertEquals(gTester.getScoreSize(), 4);
	}
	@Test
	public void sumTest() {
		assertEquals(317, gTester.sum());
		
		
	}
	@Test
	public void minimumTest() {
		assertEquals(60.0, gTester.minimum());
		
		
	}
	@Test
	public void finalScoreTest() {
		assertEquals(257, gTester.finalScore());
		
	}
	
	
	
	
	
	
	
	
	

}
