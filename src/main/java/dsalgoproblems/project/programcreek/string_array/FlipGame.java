package dsalgoproblems.project.programcreek.string_array;

/**
 * @author shekh
 */
public class FlipGame {

	public void flipGame(String s){
		char[] x = s.toCharArray();
		for(int i = 0; i < s.length()-1;i++){
			if(x[i] == x[i+1] && x[i]=='+'){
				x[i] = '-';
				x[i+1] = '-';
				System.out.println(String.valueOf(x));
				x[i] = '+';
				x[i+1] = '+';
			}
		}
	}
	
	public static void main(String[] args) {
		new FlipGame().flipGame("++----+++++---+-");
	}
}