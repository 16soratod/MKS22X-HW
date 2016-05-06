public class BSTree<T extends Comparable<T>>{
	private class Node{
		T data;
		Node left;
		Node right;

		public Node(T data){
			this.data = data;
		}
		public T getData(){
			return data;
		}
		public void setData(T data){
			this.data = data;
		}
		public Node getLeft(){
			return left;
		}
		public void setLeft(Node left){
			this.left = left;
		}
		public Node getRight(){
			return right;
		}
		public void setRight(Node right){
			this.right = right;
		}

		//real methods here
		public int height(){
			return heightH(1, this);
		}
		private int heightH(int i, Node n){
			if (n.getRight() == null && n.getLeft() == null){
				return i;
			}else if (n.getLeft() == null){
				return heightH(i + 1, n.right);
			}else if (n.getRight() == null){
				return heightH(i + 1, n.left);
			}
			int rn = heightH(i+1, n.right);
			int ln = heightH(i+1, n.left);
			if (rn > ln) {
				return rn;
			}
			return ln;
		}
		public void add(T value){
			if (getData() == null){
				setData(value);
			}else{
				addH(this, value);
			}
		}
		private void addH(Node c, T value){
			if (value.compareTo(c.getData()) > 0) {
				if (c.getRight() == null) {
					c.setRight(new Node(value));
				}else {
					addH(c.getRight(), value);
				}
			}else if (value.compareTo(c.getData()) <= 0) {
				if (c.getLeft() == null) {
					c.setLeft(new Node(value));
				}else {
					addH(c.getLeft(), value);
				}
			}
		}
		public String toString(){
			return data.toString();
		}
		public boolean contains(T value){
			if (getData() == null) {
				return false;
			}else {
				return containsH(value, this);
			}
		}
		private boolean containsH(T value, Node c){
			if (c.getData().compareTo(value) == 0) {
				return true;
			}
			if (c.getLeft() == null && c.getRight() == null) {
				return false;
			}else if (c.getLeft() == null) {
				return containsH(value,c.getRight());
			}else if (c.getRight() == null) {
				return containsH(value,c.getLeft());
			}else {
				return containsH(value, c.getLeft()) || containsH(value,c.getRight());
			}
		}
	}


	private Node root;

	public BSTree(){
		root = new Node(null);
	}
    //OUTER methods here are wrapper methods for the root
    public void add(T value){
		root.add(value);
	}
	public int getHeight(){
		if (root.getData() == null) {
			return 0;
		}
		return root.height();
	}
	public boolean contains(T value){
		return root.contains(value);
	}
	public String toString(){
		if (root.getData() == null) {
			return "";
		}else{
			return toStringH(root);
		}
	}
	private String toStringH(Node c){
		if (c.getRight() == null && c.getLeft() == null) {
			return " " + c.toString() + "_ _";
		}else if (c.getRight() == null) {
			return " " + c.toString() + toStringH(c.getLeft()) + "_";
		}else if (c.getLeft() == null) {
			return " " + c.toString() + "_" + toStringH(c.getRight());
		}else{
			return " " + c.toString() + toStringH(c.getLeft()) + toStringH(c.getRight());
		}
	}
}