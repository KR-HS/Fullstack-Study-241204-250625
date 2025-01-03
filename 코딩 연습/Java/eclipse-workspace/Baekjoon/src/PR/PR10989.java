package PR;
import java.util.*;
import java.io.*;
public class PR10989{
    public static void main(String args[]) throws NumberFormatException,IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int ar: list){
            sb.append(ar).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}