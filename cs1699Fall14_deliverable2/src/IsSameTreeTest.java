import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;


public class IsSameTreeTest {
	
	@Test
	//test 1
	public void emptyTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root1=null;
		TreeNode root2=null;
		
		boolean result = tr.isSameTree(root1,root2);
		assertTrue(result);
	}

}
