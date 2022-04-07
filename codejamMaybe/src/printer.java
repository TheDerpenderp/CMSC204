import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class printer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = sc.nextInt();


		for(int i = 0;i<cases;i++){
			System.out.print("Case #"+(i+1)+":");

			int[][] mat = new int[3][4];
			for(int k =0;k<3;k++) {

				for(int j =0;j<4;j++) {
					mat[k][j] = sc.nextInt();


				}

			}
			//go by col to find min
			int[] minAr = new int[4];
			for(int k =0;k<4;k++) {

				for(int j =0;j<3;j++) {
					if(minAr[k]>mat[j][k])
						minAr[k]=mat[j][k];



				}

			}
			int tot = minAr[0]+minAr[1]+minAr[2]+minAr[3];
			if(tot<1000000) {
				System.out.print(" IMPOSSIBLE");
				
			}
			int total = 0;
			int count = 0;
			int[] solution = new int[4];
			while(total<1000000) {
				total+=minAr[count];
				
				if(total==1000000) {
					solution[count] = total;
					break;
				}
				solution[count] = total;
				
				
				count++;
			}
			if(total>1000000) {
				int calc = 0;
				for(int aaaah = 0;i<count-1;i++) {
					calc+=minAr[aaaah];
				}
					int toadd = 1000000-calc;
					int whaaa = minAr[count]-toadd;
					solution[count] = whaaa;
				
			}
			for(Integer in: solution) {
				System.out.print(" "+in);
				
			}
			


			System.out.println();
		}


	}

}

