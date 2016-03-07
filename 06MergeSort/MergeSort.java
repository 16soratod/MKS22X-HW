public class MergeSort{
	int[][] data;
	public MergeSort(int[][] data){
		this.data = data;
	}
	public static void merge(int[] data, int start, int end, int start1, int end1){
		int[][] nData = new int[end1 - start1 + (end - start) + 2];
		int count = start;
		if(start == start2){
			return;
		}
		if(s2<s1){
			count = start2;
		}
		for(int i = 0; i < nData.length; i++){
			if(start > end){
				nData[i] = data[start2];
				start2++;
			}else if(start > end){
				nData[i] = data[start];
				start++;
			}else if(data[start] <= data[start1]){
				nData[i] = data[start];
			}else if(data[start1] < data[start]){
				nData[i] = data[start1];
				start1++;
			}
		}
		for(int i = 0l i < nData.length; i++){
			data[i + count] = nData[i];
		}
	}
}