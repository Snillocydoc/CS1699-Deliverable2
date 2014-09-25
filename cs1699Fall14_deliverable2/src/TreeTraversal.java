import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//This class supports 7 functions
//1. inorder traversal of binary tree [Cody]
//2. preorder traversal of binary tree [Cody]
//3. postorder traversal of binary tree [Cody]
//4. levelorder traversal of binary tree 
//5. check if two binary trees are the same [Cody]
//6. check if two binary trees are symmetric
//7. flatten a binary tree to a linked list

public class TreeTraversal {
	List<List<Integer>> result1 = null;
	List<Integer> result2=null;
	ArrayList<Character> leftResult=null;
    ArrayList<Character> rightResult=null;
	
	public TreeTraversal(){//constructor
		result1 = new ArrayList<List<Integer>>();
		result2= new ArrayList<Integer>();
		leftResult=new ArrayList<Character>();
	    rightResult=new ArrayList<Character>();
	}
	
	public void levelOrder(TreeNode root, int level){
		if(result1.size()>level)
			result1.get(level).add(root.val);
		else{
			List<Integer> tempList=new ArrayList<Integer>();
			tempList.add(root.val);
			result1.add(tempList);
		}

		if(root.left!=null)
			levelOrder(root.left,level+1);
		if(root.right!=null)
			levelOrder(root.right,level+1);
	}

	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		result1.clear();
		//this version use recursion
		int level=0;

		if(root==null)
			return result1;

		levelOrder(root,level);

		return result1;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		result2.clear();
		Stack<TreeNode> st=new Stack<TreeNode>();

		TreeNode p=root;
		List<Integer> result= new ArrayList<Integer>();

		do{
			//go to the left most
			while(p!=null){
				st.push(p);
				p=p.left;
			}
			TreeNode q=null;
			while(!st.empty()){
				p=st.peek();
				st.pop();

				if(p.right==q){
					result.add(p.val);
					q=p;
				}else{
					st.push(p);
					p=p.right;
					break;
				}
			}
		}while(!st.empty());
		return result;
	}

	public void preorder(TreeNode root){
		if(root!=null){
			result2.add(root.val);
			if(root.left!=null)
				preorder(root.left);
			if(root.right!=null)
				preorder(root.right);
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		result2.clear();
		preorder(root);

		return result2;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		result2.clear();
		Stack<TreeNode> st=new Stack<TreeNode>();
		//List<Integer> result= new ArrayList<Integer>();

		if(root==null)
			return result2;
		TreeNode p=root;

		while(!st.empty()||p!=null){
			if(p!=null){
				st.push(p);
				p=p.left;
			}else{
				p=st.pop();
				result2.add(p.val);
				p=p.right;
			}
		}
		return result2;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p!=null && q==null) || (p==null && q!=null))
            return false;
            
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

	
        
    public boolean compareLeftRightResult(ArrayList<Character> leftResult,ArrayList<Character> rightResult){
        if(leftResult.size()!=rightResult.size())
            return false;
        
        for(int i=0; i< leftResult.size(); i++){
            if(!leftResult.get(i).equals(rightResult.get(i)))
                return false;
        }
        
        return true;
    }
    
    public void rootLeftRight(TreeNode root){
        if(root==null){
            leftResult.add('n');
            return;
        }else
            leftResult.add((char)root.val);
        
        rootLeftRight(root.left);
        rootLeftRight(root.right);
    }
    
    public void rootRightLeft(TreeNode root){
        if(root==null){
            rightResult.add('n');
            return;
        }else
            rightResult.add((char)root.val);
        
        rootRightLeft(root.right);
        rootRightLeft(root.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        
        rootLeftRight(root.left);
        rootRightLeft(root.right);
        
        return compareLeftRightResult(leftResult,rightResult);
    }

    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left==null)
            return;
            
        //find the right most node (last node) of the left subtree of root
        TreeNode p=root.left;
        while(p.right!=null)//what's the complexity of this operation? is it O(log n)? complexity of this algo should be O(n log n)?
            p=p.right;
        
        //connect the right subtree of the root to the last node of the left subtree
        p.right=root.right;
        root.right=root.left;
        root.left=null;
    }
}
