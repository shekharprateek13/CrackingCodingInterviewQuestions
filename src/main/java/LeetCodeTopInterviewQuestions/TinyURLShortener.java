package LeetCodeTopInterviewQuestions;

public class TinyURLShortener {

	String idToShortURL(long n){
		// Map to store 62 possible characters
		char map[] = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
				'x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

		StringBuilder shorturl = new StringBuilder();

		// Convert given integer id to a base 62 number
		while (n > 0){
			shorturl.append(map[(int)n % 62]);
			n = n/62;
		}

		// Reverse shortURL to complete base conversion
		shorturl = shorturl.reverse();
		return shorturl.toString();
	}

	public static long  shortURLtoID(String shortURL){
		// initialize result
		long id = 0;

		// A simple base conversion logic
		for (int i=0; i < shortURL.length(); i++){
			if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z'){
				id = id*62 + shortURL.charAt(i) - 'a';
				System.out.println(shortURL.charAt(i) - 'a');
			} 
			if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z'){
				id = id*62 + shortURL.charAt(i) - 'A' + 26;
				System.out.println(shortURL.charAt(i) - 'A' + 26);
			}	          
			if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9'){
				id = id*62 + shortURL.charAt(i) - '0' + 52;
				System.out.println(shortURL.charAt(i) - '0' + 52);
			}
		}
		return id;
	}

	public static void main(String[] args) {
		System.out.println(shortURLtoID("dH0"));
	}
}