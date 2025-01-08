package PR;
import java.io.*;
import java.util.*;
public class PR1620{
    public static void main(String args[]) throws IOException,NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] nm= br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        Map<String,Integer> pocketS= new HashMap<>();
        Map<Integer,String> pocketN = new HashMap<>();
        for(int i=0;i<n;i++){
            String pocketmon=br.readLine();
            pocketS.put(pocketmon,i+1);
            pocketN.put(i+1,pocketmon);
        }
        
        for(int j=0;j<n;j++){
            String pocketmon=br.readLine();
            if(('A'<=pocketmon.charAt(0)&&pocketmon.charAt(0)<='Z')||('a'<=pocketmon.charAt(0)&&pocketmon.charAt(0)<='z'))
                System.out.println(pocketS.get(pocketmon));
            else System.out.println(pocketN.get(Integer.parseInt(pocketmon)));
            
        }
        
        
        
    }
}
