import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;


public class PreorderTraversalTest {
	@Test
	//test 1
	public void emptyTreeTest() {		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;//= new TreeNode(1);
		
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),0);
	}
	@Test
	//test 2
	public void onlyRootTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= mock(TreeNode.class);
		
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),1);
		
	}

}
