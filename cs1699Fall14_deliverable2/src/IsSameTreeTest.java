import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class IsSameTreeTest {
	@Test
	//Test 1
	//This test ensures that two empty (null) trees passed into the
	//isSameTree() function are considered the same tree.
	//The return value should be true.
	public void emptyTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root1=null;
		TreeNode root2=null;
		
		boolean result = tr.isSameTree(root1,root2);
		assertTrue(result);
	}

	@Test
	//Test 2
	//This test ensures that two trees containing only one node
	//with the same value, passed into the isSameTree() function are 
	//considered the same tree.
	//The return value should be true.
	public void onlyRootTest() {
		TreeTraversal tr = new TreeTraversal();
		TreeNode root1=new TreeNode(1);
		TreeNode root2=new TreeNode(1);
		
		assertTrue(tr.isSameTree(root1, root2));
	}

	@Test
	//Test 3
	//This test tests the return value of 2 identical 3-level complete binary trees
	//passed into the isSameTree() function.
	//The return value should be true.
	public void completeThreeLevelTreeTest() {
	
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root1= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(6);
		TreeNode p6= new TreeNode(7);
		
		TreeNode root2= new TreeNode(1);
		TreeNode q1= new TreeNode(2);
		TreeNode q2= new TreeNode(3);
		TreeNode q3= new TreeNode(4);
		TreeNode q4= new TreeNode(5);
		TreeNode q5= new TreeNode(6);
		TreeNode q6= new TreeNode(7);
		
		root1.left=p1; root1.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;
		
		root2.left=q1; root2.right=q2;
		q1.left=q3; q1.right=q4; q2.left=q5; q2.right=q6;
		
		
		assertTrue(tr.isSameTree(root1,root2));
	}
	@Test
	//Test 4
	//This test tests the return value of 2 non-identical 3-level complete binary trees
	//passed into the isSameTree() function.
	//The return value should be false.
	public void completeThreeLevelTreeTestDifferent() {
	
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root1= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(6);
		TreeNode p6= new TreeNode(7);
		
		TreeNode root2= new TreeNode(1);
		TreeNode q1= new TreeNode(2);
		TreeNode q2= new TreeNode(3);
		TreeNode q3= new TreeNode(4);
		TreeNode q4= new TreeNode(5);
		TreeNode q5= new TreeNode(6);
		TreeNode q6= new TreeNode(0);
		
		root1.left=p1; root1.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;
		
		root2.left=q1; root2.right=q2;
		q1.left=q3; q1.right=q4; q2.left=q5; q2.right=q6;
		
		
		assertFalse(tr.isSameTree(root1,root2));
	}




}

