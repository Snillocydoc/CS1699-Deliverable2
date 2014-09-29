import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class InOrderTraversalTest {
	
	@Test
	//test 1
	public void emptyTreeTest() {		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;//= new TreeNode(1);
		
		List<Integer> result = tr.inorderTraversal(root);
		assertEquals(result.size(),0);
	}
	@Test
	//test 2
	public void onlyRootTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= mock(TreeNode.class);
		
		List<Integer> result = tr.inorderTraversal(root);
		assertEquals(result.size(),1);
		
	}
	

}
