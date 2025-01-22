package PR;
import java.util.*;
import java.io.*;
public class Main2 {

	public static void main(String args[]) throws NumberFormatException,IOException{
		Scanner sc = new Scanner(System.in);
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=0;
        int maxY=0;
        int count=sc.nextInt();
        if(count==1){
            System.out.println(0);
            return;
        }
        for(int i=0;i<count;i++){
            int x= sc.nextInt();
            int y = sc.nextInt();
            if(minX>x) minX=x;
            if(minY>y) minY=y;
            if(maxX<x) maxX=x;
            if(maxY<y) maxY=y;
        }
        
        System.out.println((maxX-minX)*(maxY-minY));
    }
}
