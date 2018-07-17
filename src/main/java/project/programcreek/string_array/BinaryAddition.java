package project.programcreek.string_array;

/**
 * @author shekh
 */
public class BinaryAddition {

	public static String binaryAddition(String s1, String s2){

		if(s1.length() == 0 || !s1.contains("1")){
			return s2;
		}

		if(s2.length() == 0 || !s2.contains("1")){
			return s1;
		}

		int s1Length = s1.length() - 1;
		int s2Length = s2.length() - 1;
		int carry = 0;
		StringBuilder sbr = new StringBuilder();
		while(s1Length >= 0 && s2Length >= 0){
			int x1 = Character.getNumericValue(s1.charAt(s1Length));
			int x2 = Character.getNumericValue(s2.charAt(s2Length));

			if(x1 == 1 && x2 == 1){
				if(carry == 1){
					sbr.append("1");
					carry = 1;
				}else{
					carry = 1;
					sbr.append("0");
				}
			}

			if((x1 == 0 && x2 == 1)){
				if(carry == 1){
					sbr.append("0");
					carry = 1;
				}else{
					sbr.append(1);
				}
			}

			if(x1 == 1 && x2 == 0){
				if(carry == 1){
					sbr.append("0");
					carry = 1;
				}else{
					sbr.append("1");
				}
			}

			if(x1 == 0 && x2 == 0){
				if(carry == 1){
					sbr.append("1");
					carry = 0;
				}else{
					sbr.append("0");
				}
			}

			s1Length--;
			s2Length--;
		}
		
		while(s1Length >= 0){
			int x1 = Character.getNumericValue(s1.charAt(s1Length));
			if(x1 == 1){
				if(carry == 1){
					sbr.append("0");
					carry = 1;
				}else{
					sbr.append("1");
				}
			}
			
			if(x1 == 0){
				if(carry == 1){
					sbr.append("1");
					carry = 0;
				}else{
					sbr.append("0");
				}
			}
			s1Length--;
		}
		
		while(s2Length >= 0){
			int x1 = Character.getNumericValue(s2.charAt(s2Length));
			if(x1 == 1){
				if(carry == 1){
					sbr.append("0");
					carry = 1;
				}else{
					sbr.append("1");
				}
			}
			
			if(x1 == 0){
				if(carry == 1){
					sbr.append("1");
					carry = 0;
				}else{
					sbr.append("0");
				}
			}
			s2Length--;
		}
		
		if(carry == 1){
			sbr.append("1");
		}
		return sbr.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "101";
		String s2 = "10";
		System.out.println(binaryAddition(s1,s2));
	}
}