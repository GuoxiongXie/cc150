/* This is an implementation of a binary tree
   together with an inner class binary node.
   Reference: Yellow artichoke book P661~662 */

public class BinaryTree<T> {
    private BinaryNode<T> root;

    //constructors
    public BinaryTree(){
	root = null;
    }
    public BinaryTree(T rootItem){
	BinaryNode<T> rootNode = new BinaryNode<T>(rootItem, null, null);
	root = rootNode;
    }
    
    public BinaryNode<T> getRoot(){
	return root;
    }
    public int size(){
	return BinaryNode.size(root);
    }
    public int height(){
	return BinaryNode.height(root);
    }
    

    //tree traversal
    public void printPreOrder(){
	if(root != null)
	    root.printPreOrder();
	else
	    System.out.println("The binary tree is empty");
    }
    public void printInOrder(){
	if(root != null)
	    root.printInOrder();
	else
	    System.out.println("The binary tree is empty");
    }
    public void printPostOrder(){
	if (root != null)
	    root.printPostOrder();
	else
	    System.out.println("The binary tree is empty");
    }

    public void makeEmpty(){
	root = null;
    }
    public boolean isEmpty(){
	return root == null;
    }

    public void merge(T rootItem, BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2){
	
    }



    /* BinaryNode Class */
    private class BinaryNode<T> {
	private T element;
	private BinaryNode left;
	private BinaryNode right;

	//constructors
	public BinaryNode(){
	    this(null, null, null);
	}
	public BinaryNode(T item, BinaryNode<T> leftNode, BinaryNode<T> rightNode){
	    element = item;
	    left = leftNode;
	    right = rightNode;
	}

	public T getElement(){
	    return element;
	}
	public void setElement(T item){
	    element = item;
	}

	public BinaryNode<T> getLeft(){
	    return left;
	}
	public BinaryNode<T> getRight(){
	    return right;
	}

	public void setLeft(BinaryNode<T> leftNode){
	    left = leftNode;
	}
	public void setRight(BinaryNode<T> rightNode){
	    right = rightNode;
	}

	//size and height as static generic methods
	public static <T> int size(BinaryNode<T> node){
	    if (node == null)
		return 0;
	    return 1 + size(node.left) + size(node.right); //1 is for the current node
	}
	public static <T> int height(BinaryNode<T> node){
	    //the path length from deepest leaf to the root
	    //note that the height of a one-node tree is 0
	    
	    if (node == null)
		return -1; //setting null case to -1 will make leaf height = 0
	    return 1 + Math.max(height(node.left), height(node.right)); //1 is for the current edge
	}

	public BinaryNode<T> duplicate() {
	    /* Return a reference to a node that is the root of a duplicate of 
	       the binary tree rooted at the current node(this) */
	    BinaryNode<T> newNode = new BinaryNode<T>(this.getElement(), null, null);
	    if (this.left != null)
		newNode.setLeft(this.left.duplicate());
	    if (this.right != null)
		newNode.setRight(this.right.duplicate());
	    return newNode;
	}

	//static version of duplicate
	public static <T> BinaryNode<T> duplicate(BinaryNode<T> node){
	    if (node == null)
		return null;
	    BinaryNode<T> newNode = new BinaryNode<T>(node.getElement(), duplicate(node.getLeft()), duplicate(node.getRight()));
	    return newNode;
	}

	//Traversal methods
	public void printPreOrder(){
	    if (this != null) {
		System.out.print(this.getElement()+" ");
		if (this.left != null)
		    this.left.printPreOrder();
		if (this.right != null)
		    this.right.printPreOrder();
	    }
	}

	public void printInOrder(){
	    if (this != null){
		if (this.left != null)
		    this.left.printInOrder();
		System.out.print(this.getElement()+" ");
		if (this.right != null)
		    this.right.printInOrder();
	    }
	}

	public void printPostOrder(){
	    if (this != null){
		if (this.left != null)
		    this.left.printPostOrder();
		if (this.right != null)
		    this.right.printPostOrder();
		System.out.print(this.getElement()+" ");
	    }
	}

	//static version of traversal methods
	public static <T> void printPreOrder(BinaryNode<T> node){
	    if (node != null){
		System.out.print(node.getElement()+" ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	    }
	}

	public static <T> void printInOrder(BinaryNode<T> node){
	    if (node != null){
		printInOrder(node.left);
		System.out.print(node.getElement()+" ");
		printInOrder(node.right);
	    }
	}

	public static <T> void printPostOrder(BinaryNode<T> node){
	    if (node != null){
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.getElement()+" ");
	    }
	}
    }
}