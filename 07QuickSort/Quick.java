//import java.lang.Object;
import java.util.*;
import java.util.Random;
public class Quick{
	//private int[] list;
	private int pivot;

	public static String name(){
		return " 7, Doken, Sorato";
	}

	private static void swap(int[]data, int a, int b){
		int t = data[a];
		data[a] = data[b];
		data[b] = t;
	}
/////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/////////////////////////

	private static int partitionOld(int[] data, int left, int right){
		//random
		int index = (int)(Math.random()*(right-left+1)+left);
		//int index = (right-left+1) / 2;
		System.out.println("index "+index);
		System.out.println("data[index] " + data[index]);
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

	public static int quickSelectOld(int[]data, int k){
		return quickSelectOld(data,k,0,data.length-1);
	}
	private static int quickSelectOld(int[]data, int k, int left, int right){
		if(left==right){
			return data[left];
		}
		if(k == partitionOld(data, left, right)){
			return data[k];
		}else if(k > partitionOld(data, left, right)){
			return quickSelectOld(data, k, left, partitionOld(data, left, right)-1);
		}else{
			return quickSelectOld(data, k, partitionOld(data,left,right)+1,right);
		}
	}
	
	public static void quickSortOld(int[]data){
		quickSortOld(data,0,data.length-1);
	}

	private static void quickSortOld(int[]data,int left,int right){
		System.out.println(Arrays.toString(data));
		System.out.println("left "+left+" right "+right);
		if(left < right){
			int index = partitionOld(data,left,right);
			quickSortOld(data, left, index-1);
			quickSortOld(data, index+1,right);
		}
	}

/////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/////////////////////////

	private static int[] partition(int[] data, int left, int right){
		//random
		int index = (int)(Math.random()*(right-left+1)+left);
		System.out.println("index "+index);
		System.out.println("data[index] " + data[index]);
		//write a swap fxn
		int tempNum = data[right-left+1];
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
			//return start-1;
		}else{
			swap(data,left,start);
			//return start;
		}
		int[] tempAry = new int[data.length];
		int ctr = 0;
		int s = 0;
		int e = data.length-1;
		while(ctr < data.length){
			if(tempNum != 0){
				if(data[ctr] == 0){
					tempAry[s] = 2147483647;
					s++;
					ctr++;
				}else if(data[ctr]<tempNum){
					tempAry[s]=data[ctr];
					s++;
					ctr++;
				}else if(data[ctr]>tempNum){
					tempAry[e]=data[ctr];
					e--;
					ctr++;
				}else{
					ctr++;
				}
			}else{
				if(data[ctr]<tempNum){
					tempAry[s]=data[ctr];
					s++;
					ctr++;
				}else if(data[ctr]>tempNum){ 
					tempAry[e]=data[ctr];
					e--;
					ctr++;
				}else{
					ctr++;
				}
			}
			//ctr++;
		}
		if(tempNum != 0){
			for(int i = 0; i < data.length; i++){
				if(tempAry[i]==0){
					tempAry[i] = tempNum;
				}else if(tempAry[i]==2147483647){
					tempAry[i] = 0;
				}
			}
		}
		System.out.println(Arrays.toString(tempAry));
		for(int i = 0; i < data.length; i++){
			data[i]=tempAry[i];
		}
		//data = tempAry;
		//System.out.println(Arrays.toString(data));
		int[] ret = new int[]{s,e};
		return ret;
		//return tempAry;
	}

	public static void quickSort(int[]data){
		quickSort(data,0,data.length-1);

	}

	private static void quickSort(int[]data,int left,int right){
		System.out.println(Arrays.toString(data));
		//System.out.println("left "+left+" right "+right);
		if(right < left){}
			else{
			//int index = partitionOld(data,left,right);
			int[] temp = partition(data, left, right);
			int left2 = temp[0];
			int right2 = temp[1];
			quickSort(data, left, left2-1);
			quickSort(data, right2+1,right);
		}
	}

	public static void main(String[]args){
		/*int[] ary = new int[6000000];
		for(int i = 0; i < ary.length; i++){
			ary[i] = (int)(Math.random()*7);
		}*/
		Quick a = new Quick();
		int[] array = new int[]{7,8,4,5,6,9,0,2,3,1};
		
		int[] arrays = new int[50];
		for(int i = 0; i < arrays.length; i++){
			arrays[i] = (int )(Math.random() * 10);	
		}
		//System.out.println(a.partition(array,0,array.length));
		//System.out.println("array before: 7,8,4,5,6,9,0,2,3,1");
		//System.out.println("array after: 0,2,3,5,7,8,9 Answer should be 5");
		//a.partition(array,0,array.length-1);
		//System.out.println(a.quickselect(array, 3));
		System.out.println("array before" + Arrays.toString(arrays));
		//int[] array2 = new int[]{7,8,4,5,6,9,0,2,3,1};
		a.quickSort(arrays);
		//System.out.println(a.partition(arrays, 0, arrays.length-1));
		System.out.println("Sorted " + Arrays.toString(arrays));
		
	}

}