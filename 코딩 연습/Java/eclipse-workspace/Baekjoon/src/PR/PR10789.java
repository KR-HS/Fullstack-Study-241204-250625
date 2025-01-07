package PR;
import java.io.*;

public class PR10789{
    // https://www.acmicpc.net/problem/10798
	
    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[][] str = new String[5][15];
        
        
        for(int i=0;i<str.length;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<input.length;j++){
                str[i][j]=input[j];
            }
        }
        String sum="";
        for(int j=0;j<str[0].length;j++){
            for(int i=0;i<str.length;i++){
            	if(str[i][j]==null) continue;
            	sum+=str[i][j];
            }
        }
        System.out.println(sum);
    }
}
