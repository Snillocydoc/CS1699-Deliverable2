import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class LevelOrderTraversalTest {

	@Test
	//Test 1
	//This test ensures that when levelOrderTraversal() is called on
	//an empty (null) tree, it returns a list of size zero.
	public void emptyTreeTest() {
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;
		
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),0);
	}

	@Test
	//Test 2
	//This test ensure that when levelOrderTraversal() is called on a single node tree,
	//it returns a list of size one.
	public void onlyRootTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= mock(TreeNode.class);
		
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),1);
		
	}
	
	@Test
	//Test 3
	//This test ensures that when levelOrderTraversal() is called on a complete, three level tree,
	//three separate lists should be returned corresponding to the levels.
	//The size of each each list should be 1,2,4.
	public void completeThreeLevelTreeTest() {
		
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
		
		//check whether there are 3 levels
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),3);
		
		//check each level
		//level 1
		List<Integer> correctLevel1 = new ArrayList<Integer>();
		correctLevel1.add(1);
		assertEquals(result.get(0).size(),1);
		assertArrayEquals(result.get(0).toArray(),correctLevel1.toArray());
		
		//level 2
		List<Integer> correctLevel2 = new ArrayList<Integer>();
		correctLevel2.add(2);			correctLevel2.add(3);
		assertEquals(result.get(1).size(),2);
		assertArrayEquals(result.get(1).toArray(),correctLevel2.toArray());
		
		//level 3
		List<Integer> correctLevel3 = new ArrayList<Integer>();
		correctLevel3.add(4);			correctLevel3.add(5);
		correctLevel3.add(6);			correctLevel3.add(7);
		assertEquals(result.get(2).size(),4);
		assertArrayEquals(result.get(2).toArray(),correctLevel3.toArray());
	}
	
	@Test
	//Test 4
	//This test ensures that when levelOrderTraversal() is called on a linked-list type tree
	//that is left of the root, it returns the correct number of levels.
	//The return result size of each level should be 1,1,1,1
	public void leftInBalanceFourLevelTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		
		root.left=p1; p1.left=p2; p2.left=p3;	
		
		//check whether there are 3 levels
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),4);
		
		//check each level
		//level 1
		List<Integer> correctLevel1 = new ArrayList<Integer>();
		correctLevel1.add(1);
		assertArrayEquals(result.get(0).toArray(),correctLevel1.toArray());
		
		//level 2
		List<Integer> correctLevel2 = new ArrayList<Integer>();
		correctLevel2.add(2);
		assertArrayEquals(result.get(1).toArray(),correctLevel2.toArray());
		
		//level 3
		List<Integer> correctLevel3 = new ArrayList<Integer>();
		correctLevel3.add(3);
		assertArrayEquals(result.get(2).toArray(),correctLevel3.toArray());
		
		//level 4
		List<Integer> correctLevel4 = new ArrayList<Integer>();
		correctLevel4.add(4);
		assertArrayEquals(result.get(3).toArray(),correctLevel4.toArray());
	}
	
	@Test
	//Test 5
	//This test ensures that when levelOrderTraversal() is called on a linked-list type tree
	//that is right of the root, it returns the correct number of levels.
	//The return result size of each level should be 1,1,1,1
	public void rightInBalanceFourLevelTreeTest() {
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(3);
		TreeNode p3= new TreeNode(4);
		
		root.right=p1; p1.right=p2; p2.right=p3;	
		
		//check whether there are 3 levels
		List<List<Integer>> result = tr.levelOrderTraversal(root);
		assertEquals(result.size(),4);
		
		//check each level
		//level 1
		List<Integer> correctLevel1 = new ArrayList<Integer>();
		correctLevel1.add(1);
		assertArrayEquals(result.get(0).toArray(),correctLevel1.toArray());
		
		//level 2
		List<Integer> correctLevel2 = new ArrayList<Integer>();
		correctLevel2.add(2);
		assertArrayEquals(result.get(1).toArray(),correctLevel2.toArray());
		
		//level 3
		List<Integer> correctLevel3 = new ArrayList<Integer>();
		correctLevel3.add(3);
		assertArrayEquals(result.get(2).toArray(),correctLevel3.toArray());
		
		//level 4
		List<Integer> correctLevel4 = new ArrayList<Integer>();
		correctLevel4.add(4);
		assertArrayEquals(result.get(3).toArray(),correctLevel4.toArray());
	}
	
	@Test
	//Test 6
	//This tests the return result size of a 1000 level left/right node only binary tree.
	//The return result size of each level (1000 levels) should be 1.
	public void bigTreeTest() {

		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		List<List<Integer>> result1=tr.levelOrderTraversal(root1);
		assertEquals(result1.size(),treeSize);
		for(int i=0;i<treeSize; i++){
			assertEquals(result1.get(i).size(),1);
		}
		
		TreeNode r2= new TreeNode(0);
		TreeNode root2=r2;
		for(int i=1; i<treeSize; i++){
			r2.right= new TreeNode(i);
			r2=r2.right;
		}		
		List<List<Integer>> result2=tr.levelOrderTraversal(root2);
		assertEquals(result2.size(),treeSize);
		for(int i=0;i<treeSize; i++){
			assertEquals(result2.get(i).size(),1);
		}
	}
}
