import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class PreorderTraversalTest {
	@Test
	//This test ensures that when preorderTraversal is called on an empty tree (a null tree), 
	//it returns a list of size zero.
	public void emptyTreeTest() {		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;//= new TreeNode(1);
		
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),0);
	}
	@Test
	//This test ensure that when preorderTraversal is called on a single node tree,
	//it returns a list of size one.
	public void onlyRootTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= mock(TreeNode.class);
		
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),1);
		
	}
	@Test
	//This test checks the preorderTraversal algorithm on a seven node tree.  The test checks for the correct
	//implementation of the following: Visit the root, visit the left subtree, then visit the right subtree.
	public void completeSevenNodeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(6);
		TreeNode p6= new TreeNode(7);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;		
		
		//check that there are 7 nodes in the tree
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),7);
		
		//check that nodes are in order
		List<Integer> check = new ArrayList<Integer>();
		check.add(1);check.add(2);check.add(4);check.add(5);check.add(3);check.add(6);check.add(7);
		assertArrayEquals(result.toArray(),check.toArray());
		
		
	}
	@Test
	//This test specifically ensures that the preorderTraversal visits the current node first, then the left subtree,
	//which is an important aspect of the Pre-order Traversal algorithm
	public void leftInBalanceFourLevelTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		
		root.left=p1; p1.left=p2; p2.left=p3;	
		
		//check whether there are 4 nodes
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),4);
		
		//check that nodes are in order
		List<Integer> check = new ArrayList<Integer>();
		check.add(1);check.add(2);check.add(3);check.add(4);
		assertArrayEquals(result.toArray(),check.toArray());
		
		
	}
	@Test
	//This test specifically ensures that the preorderTraversal visits the current node first,
	//then the right subtree if there is no left subtree,
	//which is an important aspect of the Pre-order Traversal algorithm
	public void rightInBalanceFourLevelTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		
		root.right=p1; p1.right=p2; p2.right=p3;	
		
		//check whether there are 4 nodes
		List<Integer> result = tr.preorderTraversal(root);
		assertEquals(result.size(),4);
		
		//check that nodes are in order
		List<Integer> check = new ArrayList<Integer>();
		check.add(1);check.add(2);check.add(3);check.add(4);
		assertArrayEquals(result.toArray(),check.toArray());
		
		
	}
	

}