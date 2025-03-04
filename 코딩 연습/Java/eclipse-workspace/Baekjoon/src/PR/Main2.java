package PR;
import java.io.*;
import java.util.*;

public class Main2 {	
	
	public static void main(String args[]) throws IOException,NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Map<String,Integer> map = new HashMap<>();
        
        
         for(int i=0;i<n;i++) {
        	String input = br.readLine();
        	if(input.length()<m) continue;
        	if(map.containsKey(input)) {
        		map.put(input, map.get(input)+1);
        	}else {
        		map.put(input, 1);
        	}
        }    
//         List<String> list = new ArrayList<>();
//         for(String key:map.keySet()) {
//         	if(list.size()==0) list.add(key);
//         	else {
//         		for(int i=0;i<list.size();i++) {
//         			if(map.get(key)>map.get(list.get(i))) {
//         				list.add(i,key);
//         				break;
//         			}else if(map.get(key)==map.get(list.get(i))) {
//         				if(key.length()>list.get(i).length()) {
//         					list.add(i,key);
//         					break;
//         				}else if(key.length()==list.get(i).length()) {
//         					if(key.compareTo(list.get(i))<0) {
//         						list.add(i,key);
//         						break;
//         					}
//         				}else {
//         					if(i==list.size()-1) {
//             					list.add(key);
//             					break;
//             				}
//         				}
//         			}else {
//         				if(i==list.size()-1) {
//         					list.add(key);
//         					break;
//         				}
//         			}
//         		}
//         	}
//         }
         
         List<String> list = new ArrayList<>(map.keySet());
         list.sort((a, b) -> {
             int countComparison = Integer.compare(map.get(b), map.get(a)); // 빈도수 내림차순
             if (countComparison != 0) return countComparison;
             
             // 빈도수가 같으면 길이 내림차순
             int lengthComparison = Integer.compare(b.length(), a.length());
             if (lengthComparison != 0) return lengthComparison;
             
             // 길이도 같으면 사전순 오름차순
             return a.compareTo(b);
         });
         
         for(String s: list) {
         	bw.write(s+"\n");
         }
        bw.flush();
        bw.close();
        br.close();
	}
}

