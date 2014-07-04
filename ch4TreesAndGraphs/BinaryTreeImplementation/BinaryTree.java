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
}