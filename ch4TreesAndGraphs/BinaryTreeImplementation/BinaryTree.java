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
	//TODO
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
	    //TODO
	}
	public static <T> int height(BinaryNode<T> node){
	    //TODO
	}

	public BinaryNode<T> duplicate() {
	    //TODO
	}

	//Traversal methods
	public void printPreorder(){
	    //TODO
	}

	public void printInorder(){
	    //TODO
	}

	public void printPostOrder(){
	    //TODO
	}
    }
}