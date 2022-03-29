
public class testing {

	public static void main(String[] args) {
		int[] hash= new int[13];
		for(int i=0;i<hash.length;i++) 
			hash[i]=-20000;
		
		int[] added = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};
		for(int i:added) {
			int ip = i%13;
			int q = i/13;
			int offset;
			
		
			if(hash[i%13] == -20000) {
				hash[i%13]= i;
				
			}
			else {
				
				if(q%13!=0)
					offset=q;
				else
					offset = 19;
				
				ip = (ip+offset)%13;
				
				
				while(hash[ip] != -20000) {
					ip=(ip+offset)%13;
					System.out.println(i);
				}
				hash[ip]= i;
				
			}
			
		}
		
		
		
	}


	}


