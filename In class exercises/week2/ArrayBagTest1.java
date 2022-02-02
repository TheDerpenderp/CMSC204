import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayBagTest1 {

	private FixedSizeArrayBag<String> theBag;
	
	@BeforeEach
	void setUp() throws Exception {
		theBag = new FixedSizeArrayBag<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		theBag = null;
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
