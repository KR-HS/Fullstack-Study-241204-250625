package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	static int k=0;
	static int ct=0;
	static int[] tmp=null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws IOException,NumberFormatException{
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        k=Integer.parseInt(str[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=Integer.parseInt(input[i]);
        }
        MergeSort(arr,0,arr.length-1);
        if(ct<k) bw.write(-1+"\n");
        bw.flush();
        bw.close();
        br.close();
	}
	public static void MergeSort(int[] arr,int start,int end) throws IOException,NumberFormatException{
		if(start<end) {
			int mid = (start+end)/2;
			MergeSort(arr,start,mid);
			MergeSort(arr,mid+1,end);
			Merge(arr,start,mid,end);
		}
	}
	public static void Merge(int[] arr, int start, int mid, int end) throws IOException,NumberFormatException{
		tmp = new int[end];
		int i=start;
		int j = mid+1;
		int t = 0;
		while(i<=mid && j<=end) {
			if(arr[i]<=arr[j]) {
				tmp[t++]=arr[i++];
			}else {
				tmp[t++]=arr[j++];
			}
		}
		while(i<=mid) {
			tmp[t++]=arr[i++];
		}
		while(j<=end) {
			tmp[t++]=arr[j++];
		}
		i=start;t=0;
		while(i<=end) {
			arr[i++]=tmp[t++];
			ct++;
			if(ct==k) {
				bw.write(tmp[--t]+"\n");
				bw.flush();
				return;
			}
		}
	}
}

