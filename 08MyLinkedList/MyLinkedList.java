public class MyLinkedList<T>{
	LNode start;
	LNode end;
	int size;

	public T get(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("don't do it");
		}
		LNode p = start;
		for(int i = 0; i < index; i++){
			p = p.getNext();
		}
		return p.getValue();
	}

	public int set(int index,T newValue){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("enter positive index");
		}
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
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("oops");
		}
		LNode p = start;
		if(start != null){
			for (int i = 0; i < index-1; i++) {
				if (p.getNext() == null)
					return -1;
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		size--;
		return index;
	}

	public boolean add(int index, T value){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("oh no!");
		}
		LNode p = start;
		LNode temp = new LNode(value);
		if(p != null){
			for(int i = 0; i < index && p.getNext() != null; i++){
				p = p.getNext();
			}
		}
		temp.setNext(p.getNext());
		p.setNext(temp);
		size++;
		//LNode newL = new LNode(value);
		return true;
	}

	public boolean add(T value){
		size++;
		//end++;
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

	public int indexOf(T value){
		/*if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("oopsie daisies");
		}*/
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
		return ret + "]" + " HEAD: " + start.getValue() + " TAIL: " + end;
	}

/*
	public String toString(boolean yes){
		if(yes){
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
			return ret + "]" + " HEAD: " + indexOf(start) + " TAIL: " + indexOf(end);
		}	
	}
	*/

	//////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~////////////////////

	private class LNode{
		private T data;
		private LNode next;

		public LNode(){}

		public LNode(T data){
			this.data = data;
		}

		public void setValue(T value){
			data = value;
		}

		public LNode getNext(){
			return next;
		}

		public T getValue(){
			return data;
		}

		public void setNext(LNode next){
			this.next = next; 
		}
	}

}