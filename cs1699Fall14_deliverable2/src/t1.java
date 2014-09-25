import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class t1 {

	@Test
	public void test() {
//		fail("Not yet implemented");
		//FrequencyBag fb= new FrequencyBag();
		
		FrequencyBag fb= mock(FrequencyBag.class);
		
		assertEquals(fb.size(),0);
	}

}
