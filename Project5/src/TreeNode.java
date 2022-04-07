
public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;
	
	public TreeNode(T dataNode) {
		left  = null;	
		right = null;		
		data = dataNode;
		
		
	}
	public TreeNode(TreeNode<T> node) {
		left  = node.left;	
		right = node.right;		
		data = node.data;
		
	}
	public T getData() {
		return data;
	}

}
