//import java.lang.Object;
import java.util.*;
import java.util.Random;
public class Quick{
	//private int[] list;
	private int pivot;
	
	private static int partition(int[] data, int left, int right){
		Random r = new Random();
		int pos = r.nextInt(right);
		int pivot = data[pos];
		int ret = 0;
		List<Integer> leftL = new ArrayList<Integer>();
		List<Integer> rightL = new ArrayList<Integer>();
		for(int i = left; i < (right-left); i++){
			if(data[i] < pivot){
				leftL.add(data[i]);
			}else{
				rightL.add(data[i]);
			}
		}
		leftL.add(pivot);
		leftL.addAll(rightL);
		data = convert(leftL);
		for(int i = 0; i < data.length; i++){
			if(data[i] == pivot){
				ret = i;
			}
		}
		return ret;
	}

	public static int[] convert(List<Integer> integers){
    	int[] ret = new int[integers.size()];
    	for(int i=0; i < ret.length; i++){
        	ret[i] = integers.get(i).intValue();
    	}
    	return ret;
	}

	public static int quickselect(int[]data, int k){
		return quickselect(data,k,0,data.length-1);
	}
	private static int quickselect(int[]data, int k, int left, int right){
		if(k == partition(data, left, right)){
			return data[k];
		}else if(k > partition(data, left, right)){
			return quickselect(data, k, left, partition(data, left, right));
		}else{
			return quickselect(data, k, partition(data,left,right),right);
		}
	}
	public static void main(String[]args){
		Quick a = new Quick();
		int[] array = new int[]{0,5,7,3,8,2,9};
		//System.out.println(a.partition(array,0,array.length));
		System.out.println("array before: 0,5,7,3,8,2,9");
		System.out.println("array after: 0,2,3,5,7,8,9 Answer should be 3");
		System.out.println(a.partition(array,0,array.length-1));
		a.quickselect(array, 1);
	}

}