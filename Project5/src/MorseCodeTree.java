import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	public TreeNode<String> root;

	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();

	}


	public TreeNode<String> getRoot() {
		return root;
	}


	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);

	}


	public void insert(String code, String result) {
		TreeNode<String> mine = root;
		addNode(mine, code, result);
		
	}


	public void addNode(TreeNode<String> root, String code, String letter) {
		System.out.println(letter);
		if(code.equals("")) {

			return;
		}
		if(code.charAt(0) == '.') {
			if(root.left == null)
				root.left = new TreeNode<String>(letter);
			addNode(root.left,code.substring(1), letter);
			return; 
		}
		if(root.right == null)
			root.right = new TreeNode<String>(letter);
		addNode(root.right,code.substring(1), letter);
		return;
	}

	public String fetch(String code) {
		TreeNode<String> yes = root;
		return fetchNode(yes, code);
	}

	public String fetchNode(TreeNode<String> root, String code) {
		if(code.equals("")) {
			return root.data;
		}
		if(code.charAt(0) == '.')
			return fetchNode(root.left,code.substring(1));
		else if(code.charAt(0) == '-')
			return fetchNode(root.right,code.substring(1));
		return " ";
	}


	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// not implemented
		return null;
	}


	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		//not used
		return null;
	}

	@Override
	public void buildTree() {
		String[] theTreeLetters = {"e","t","i","a","n","m","s","u","r","w","d","k","g","o","h","v","f","l","p","j","b","x","c","y","z","q"};
		String[] theTreeCode = {".","-","..",".-","-.","--","...","..-",".-.",".--","-..","-.-","--.","---","....","...-","..-.",".-..",".--.",".---","-...","-..-","-.-.","-.--","--..","--.-"};
		for(int i = 0; i<theTreeLetters.length;i++) {

			setRoot(insert(theTreeCode[i],theTreeLetters[i]).getRoot());
		}
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toReturn = new ArrayList<String>();
		TreeNode current = root;
		toArrayListhelp(current, toReturn);
		return toReturn;
	}
	private void toArrayListhelp(TreeNode<String> node, ArrayList<String> yes){
		if(node == null) {
			return;
		}
		toArrayListhelp(node.left, yes);
		yes.add(node.data);
		toArrayListhelp(node.right, yes);
		
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub

	}


}
