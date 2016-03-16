public class MyLinkedList{
	LNode start;
	LNode end;
	int size;

	private int get(int index){
		return index;
	}

	private int set(int index,int newValue){
		return index;
	}

	private int size(){
		return size;
	}

	private int remove(int index){
		return index;
	}

	public boolean add(int index, int value){	
		return true;
	}

	public boolean add(int value){
		size++;
		LNode current = start;
		if (current == null){
			current = new LNode(value, new LNode());
			end = current;
			return true;
		}else{
			return false;
		}
	}

	private int indexOf(int value){
		return value;
	}

	public String tostring(){
		String ret = "";
		LNode a = new LNode();
		for(int i = 0; i < size; i++){
			ret += a.getValue();
			ret += ",";
		}
		return ret;
	}
	public class LNode{
		int data;
		LNode next;

	public LNode(){}

	public LNode(int data, LNode next){
		this.data = data;
		this.next = next;
	}

	public void setValue(int value){
		data = value;
	}

	public LNode getNext(){
		return next;
	}

	public int getValue(){
		return data;
	}

	public void setNext(LNode value){
		next = value; 
	}
}

}