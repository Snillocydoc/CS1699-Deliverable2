import static org.junit.Assert.*;

import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class LevelOrderTraversalTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		//FrequencyBag fb= new FrequencyBag();
		//FrequencyBag fb= mock(FrequencyBag.class);
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;//= new TreeNode(1);
		
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),0);
	}

	@Test
	public void test2() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),0);
	}
}
