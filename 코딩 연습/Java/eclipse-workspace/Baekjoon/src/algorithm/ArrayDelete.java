package algorithm;

public class ArrayDelete {
	public static void main(String args[]) {
		// 배열의 삭제 - 배열은 삭제의 개념이 없음 ( 크기가 고정이라서)
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		int index=5; // 삭제할위치
		
		// 크기가 -1인 배열하나 생성
		int[] newArr = new int[arr.length-1];
		
		// 원본 배열의 삭제할 위치부터 마지막까지 당겨옴
		for(int i=index;i<arr.length;i++) {
			arr[i]=arr[i+1];
		}
		//복사
		for(int i=0;i<newArr.length;i++) {
			newArr[i]=arr[i];
		}
		
		// 기존 arr 삭제
		arr= newArr;
		newArr=null;
	}
	
}
