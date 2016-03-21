public class Driver08{
	public static void main(String[]args){
		MyLinkedList list = new MyLinkedList();
		list.add(5);
		list.add(100);
		list.add(7);
		list.add(9);
		System.out.println(list.get(1));
		System.out.println(list.size());
		System.out.println(list.indexOf(200));
		System.out.println(list);
		//list.remove(2);
		//list.set(2,200);
		list.add(2,3);
		System.out.println(list);
	}
}