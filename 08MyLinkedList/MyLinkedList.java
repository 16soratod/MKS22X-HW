import java.util.Iterator;
import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{

//////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~////////////////////

	public Iterator<T> iterator(){
		return new LLIterator();
	}

	public class LLIterator implements Iterator<T>{
		LNode current;
		public LLIterator(){
			current=start;
		}
		public boolean hasNext(){
			if(current.getNext() == null){
				return false;
			}else{
				return true;
			}
		}
		public void remove(){
			throw new UnsupportedOperationException("oops");
		}
		public T next(){
			current = current.getNext();
			if(current == null){
				throw new NoSuchElementException();
			}
			return current.getValue();
		}
	}

//////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~////////////////////

	LNode start;
	LNode end;
	int size;
	/*
	public static double sumL(MyLinkedList list){
		double ret = 0.0;
		int ctr = 0;
		while(list.hasNext()){
			ret = ret + list.get(ctr);
			ctr++;
		}
		return ret;	
	}*/

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
		if(index == size - 1){
			end = p;
		}
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
		if(index == 0){
			//LNode temp = p.getNext();
			p.setValue(null);
			start = p.getNext();
			p.setNext(p.getNext().getNext());
		}else if(start != null){
			for (int i = 0; i < index-1; i++) {
				if (p.getNext() == null)
					return -1;
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
		}
		if(index == size-1){
				end = p;
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
		if(index == 0){
			temp.setNext(p);
			start = temp;
		}else if(p != null){
			for(int i = 0; i < index && p.getNext() != null; i++){
				p = p.getNext();
			}
			temp.setNext(p.getNext());
			p.setNext(temp);
		}
		if(index == size){
			end = temp;
		}
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
			end = start;
			return true;
		}else{
			LNode p = start;
			while(p.getNext() != null){
				p = p.getNext();
			}
			p.setNext(new LNode(value));
			end = p.getNext();
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
				ret+= ", ";
			}
			next = next.getNext();
			ctr++;
		}
		return ret + "]";// + " HEAD: " + start.getValue() + " TAIL: " + end.getValue();
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

	public static void main(String[] args) {
		MyLinkedList<String> n = new MyLinkedList<String>();

		n.add("S");
		n.add("N");
		n.add("R");
		n.add("T");
		n.add("Y");
		n.add("W");
		n.add("Q");
		n.add("S");
		System.out.println(n);
		for(String l : n){
			System.out.println(l);
		}
	}

}