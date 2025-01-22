package PR;
import java.util.*;
import java.io.*;
public class Main2 {

	public static void main(String args[]) throws NumberFormatException,IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] first = br.readLine().split(" ");
        int firstX=Integer.parseInt(first[0]);
        int firstY=Integer.parseInt(first[1]);
        
        int countX=0;
        int countY=0;
        
        int findX=0;
        int findY=0;
        
        for(int i=0;i<2;i++){
            String[] input = br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);
            if(firstX!=x) findX=x;
            if(firstY!=y) findY=y;
            if(firstX==x) countX++;
            if(firstY==y) countY++;
        }
        if(countX==0) findX=firstX;
        if(countY==0) findY=firstY;
        
        bw.write(findX+" "+findY+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
