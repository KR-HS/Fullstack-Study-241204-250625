package quiz04;

public class ToArray {

	String toArray(int[] arr) {
		String answer="[";
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1) {
				answer+=arr[i];
				break;
			}
			answer+=arr[i]+",";
		}
		answer+="]";
		return answer;
	}
	
	String toArray(char[] chr) {
		String answer="[";
		for(int i=0;i<chr.length;i++) {
			if(i==chr.length-1) {
				answer+="\'"+chr[i]+"\'";
				break;
			}
			answer+="\'"+chr[i]+"\'"+",";
		}
		answer+="]";
		return answer;
	}
	
	String toArray(String[] str) {
		String answer="[";
		for(int i=0;i<str.length;i++) {
			if(i==str.length-1) {
				answer+="\""+str[i]+"\"";
				break;
			}
			answer+="\""+str[i]+"\""+",";
		}
		answer+="]";
		return answer;
	}
}
