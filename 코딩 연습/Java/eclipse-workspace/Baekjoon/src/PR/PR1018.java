package PR;
import java.io.*;
import java.util.Arrays;

public class PR1018 {
	public static void main(String args[]) throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] num = br.readLine().split(" ");
		int h = Integer.parseInt(num[0]);
		int w = Integer.parseInt(num[1]);

		String[][] box = new String[h][w];
		String[][] bStartBox=new String[8][8];
		String[][] wStartBox=new String[8][8];

		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i%2==0) {
					if(j%2==0) {
						bStartBox[i][j]="B";
						wStartBox[i][j]="W";
					}
					else {
						bStartBox[i][j]="W";
						wStartBox[i][j]="B";
					}
				}
				else {
					if(j%2==0) {
						bStartBox[i][j]="W";
						wStartBox[i][j]="B";
					}
					else {
						bStartBox[i][j]="B";
						wStartBox[i][j]="W";
					}
				}
			}
		}


		
		
		int min=h*w;
		int count_W=0;
		int count_B=0;		
		for(int i=0;i<h;i++) {
			box[i]=br.readLine().split("");
		}

		for(int i=0;i+7<h;i++) {
			for(int j=0;j+7<w;j++) {
				count_W=0;
				count_B=0;

				for(int k=0;k<8;k++) {
					for(int l=0;l<8;l++) {
						if(!box[i+k][j+l].equals(bStartBox[k][l])) count_B++;
						if(!box[i+k][j+l].equals(wStartBox[k][l])) count_W++;
					}
				}
				
				
				if(min>count_W||min>count_B) {
					min=count_W>count_B?count_B:count_W;
				}

			}
		}

		System.out.println(min);

	}
}
