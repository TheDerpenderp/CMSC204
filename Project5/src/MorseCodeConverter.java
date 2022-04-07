import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	public static MorseCodeTree yes= new MorseCodeTree();
	
	public MorseCodeConverter(){
		yes = new MorseCodeTree();
		
	}
 	public static String convertToEnglish(String code){
 		String[] toReturn = code.split(" ");
 		
 		String yess = "";
 		for(String s: toReturn) {
 			System.out.println(s);
 				yess+= yes.fetch(s);
 		}
		return yess;
 		
 	}
	public static String printTree() {
		ArrayList<String> a = yes.toArrayList();
		String toRet = "";
		for(String s: a) {
			toRet+=s+" ";
		}
		return toRet;
	}
	
	public static String convertToEnglish(File inputFile) throws FileNotFoundException{
		Scanner fScanner = null;
		try {
			fScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
		}
		String toRet = "";
		while(fScanner.hasNextLine()){
			toRet+=convertToEnglish(fScanner.nextLine());
		}
		return toRet;
	}

}
