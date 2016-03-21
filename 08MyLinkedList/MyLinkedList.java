public class MyLinkedList{
	LNode start;
	LNode end;
	int size;

	public int get(int index){
		LNode p = start;
		for(int i = 0; i < index; i++){
			p = p.getNext();
		}
		return p.getValue();
	}

	public int set(int index,int newValue){
		LNode p = start;
		for(int i = 0; i < index; i++){
			p = p.getNext();
		}
		p.setValue(newValue);
		return index;
	}

	public int size(){
		return size;
	}

	public int remove(int index){
		LNode p = start;
		LNode b = null;
		for(int i = 0; i < index; i++){
			p = p.getNext();
		}
		p.setNext(p.getNext());
		//p.setNext()
		return index;
	}

	public boolean add(int index, int value){
		LNode p = start;
		for(int i = 0; i < index-1; i++){
			p = p.getNext();
		}
		size++;
		//LNode newL = new LNode(value);
		p.setNext(new LNode(value));
		return true;
	}

	public boolean add(int value){
		size++;
		//LNode current = start;
		if (start == null){
			start = new LNode(value);
			//end = current;
			return true;
		}else{
			LNode p = start;
			while(p.getNext() != null){
				p = p.getNext();
			}
			p.setNext(new LNode(value));
		}
		return true;
	}

	public int indexOf(int value){
		for(int i = 0; i < size; i++){
			if(value == get(i)){
				return i;
			}
		}
		return (-1);
	}

	public String toString(){
		String ret = "[";
		//LNode a = new LNode();
		LNode next = start;
		int ctr = 0;
		while(ctr < size){
			ret+=next.getValue();
			if(next.getNext() != null){
				ret+= " , ";
			}
			next = next.getNext();
			ctr++;
		}
		return ret + "]";
	}

	//////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~////////////////////

	private class LNode{
		private int data;
		private LNode next;

		public LNode(){}

		public LNode(int data){
			this.data = data;
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

		public void setNext(LNode next){
			this.next = next; 
		}
	}

}