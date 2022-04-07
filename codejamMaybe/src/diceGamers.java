import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class diceGamers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = sc.nextInt();
		
		
		for(int i = 0;i<cases;i++){
			System.out.print("Case #"+(i+1)+": ");
			int numDice = sc.nextInt();
			
			int[] sides = new int[numDice];
			for(int k = 0;k<numDice;k++) {
				sides[k] = sc.nextInt();
				
				
			}
			Arrays.sort(sides);
		    int maxStraight = 1;
		    for(int j = 0;j<sides.length;j++) {
		    	if(sides[j]>=maxStraight)
		    		maxStraight++;
		    }
			
		    System.out.print(maxStraight-1);
			
				System.out.println();
			}


		}

	}

