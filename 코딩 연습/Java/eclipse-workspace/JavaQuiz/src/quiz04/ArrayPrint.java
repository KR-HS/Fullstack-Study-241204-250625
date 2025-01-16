package quiz04;


public class ArrayPrint {
	
	
	/*
	 * 1. ArrayPrint는 접근제어자를 통해서, 외부에서 객체로 생성할 수 없도록 만들어 주세요.
	 * 2. 메서드에는 public static을 붙여서 메인에서 호출 해주세요.
	 */
	
	private ArrayPrint() {
		
	}
	public static ArrayPrint getArrayPrint() {
		return new ArrayPrint();
	}
	
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
