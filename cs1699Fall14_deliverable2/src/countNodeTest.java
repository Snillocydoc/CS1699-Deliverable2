import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class countNodeTest {

	@Test
	//Test 1
	//This test ensures that when countNumNode is called on an empty tree (a null tree), 
	//it returns a list of size zero.
	public void emptyTreeTest() {
		ListOperations lo= new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;
		
		int count = tr.countNumNode(root,lo);
		assertEquals(count,0);
	}
	
	@Test
	//Test 2
	//This test ensures that when countNumNode is called on a single node tree, 
	//it returns a list of size 1.
	public void onlyRootTest() {
		ListOperations lo=mock(ListOperations.class);
		TreeTraversal tr = new TreeTraversal();
		TreeNode r1= new TreeNode(0);
		
		when(lo.countRightList(any(List.class))).thenReturn(0);
		when(lo.countLeftList(any(List.class))).thenReturn(0);
		int count = tr.countNumNode(r1,lo);
		assertEquals(count,1);
	}
	@Test
	//Test 3
	//This test ensures that when countNumNode is called on a 1000 node, linked-list type tree, 
	//it returns a list of size 1000.
	public void linkedListTreeTest() {
		ListOperations lo=new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		
		
		int count = tr.countNumNode(root1,lo);
		assertEquals(count,treeSize);
	}
	
	@Test
	//This test ensures that when countNumNode is called on a 1000 node tree using a stub, 
	//it returns 1000.
	public void linkedListTreeWithStubTest() {
		ListOperations lo=mock(ListOperations.class);
		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=new TreeNode(0);//=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		
		List<String> leftResult= new ArrayList<String>();
		//stub the countLeftList and countRightList functions
		when(lo.countLeftList(any(List.class))).thenReturn(999);
		when(lo.countRightList(any(List.class))).thenReturn(0);
		int count = tr.countNumNode(root1,lo);
		assertEquals(count,treeSize);
	}
	
}
