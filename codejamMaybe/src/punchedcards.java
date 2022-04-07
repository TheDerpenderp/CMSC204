import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class punchedcards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = sc.nextInt();
		
		
		for(int i = 0;i<cases;i++){
			System.out.println("Case #"+(i+1)+":");
			int row = sc.nextInt();
			int col = sc.nextInt();

			for(int j = 0;j<(2*row+1);j++){
				for(int k = 0;k<(2*col+1);k++){
					
					if(j<2&&k<2) {
						System.out.print(".");
					}
					else if(j%2==0){
						if(k%2==0){
							System.out.print("+");
						}
						else
							System.out.print("-");
					}
					else if(j%2==1){
						if(k%2==0){
							System.out.print("|");
						}
						else
							System.out.print(".");
					}	

				}

System.out.println();


			}


		}

	}
}
