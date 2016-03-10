//import java.lang.Object;
import java.util.*;
import java.util.Random;
public class QuickTest{
	//private int[] list;
	private int pivot;

	public static String name(){
		return " 7, Doken, Sorato";
	}
	/*
	private static int partition(int[] data, int left, int right) {
		//System.out.println(right);
		//Random r = new Random();
		//int pos = r.nextInt(right-left + 1);
		int pos = (int)(Math.random()*(right-left+1));
		int pivot = data[pos];
		System.out.println(pivot);
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
*/
	private static int partition(int[] data, int left, int right){
		//random
		int index = (int)(Math.random()*(right-left+1));
		//write a swap fxn
		swap(data, index, left);
		//loop through all values, and leave them alone, or swap to end
		int start = left + 1;
		int end = right;
		while(start < end){
			if (data[start] > data[left]){
				swap(data, start, end);
				end--;
			}else{
				start++;
			}
		}
		//look at the value you converged on
		//and decide how to swap the partition element into place
		if(data[start] > data[left]){
			swap(data,left,start-1);
			return start-1;
		}else{
			swap(data,left,start);
			return start;
		}
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
		//more stopping condition
		//if(more than 1 element){do the algorithm}	
		if(left==right){
			return data[left];
		}
		//if(k == partition(data, left, right) || data.length < 2 || right == 0){
		/*	return data[k];
		}else if(k > partition(data, left, right)){
			return*/ quickselect(data, k, left, partition(data, left, right))-1;
		//}else{
			/*return*/ quickselect(data, k, partition(data,left,right)+1,right);
		}
	}

	//public static int[] quick 
	public static void main(String[]args){
		QuickTest a = new QuickTest();
		int[] array = new int[]{0,5,7,3,8,2,9};
		//System.out.println(a.partition(array,0,array.length));
		System.out.println("array before: 0,5,7,3,8,2,9");
		System.out.println("array after: 0,2,3,5,7,8,9 Answer should be 5");
		System.out.println(a.partition(array,0,array.length-1));
		//a.quickselect(array, 3);
	}

}