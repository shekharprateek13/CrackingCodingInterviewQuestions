package LeetCodeTopInterviewQuestions;

public class ReverseSignedInt {

	public static int reverse(long x) {
		long reversedNum = 0;
		while(x != 0){
			reversedNum = reversedNum*10 + x%10;
			x = x/10;
			if((Integer.MAX_VALUE < reversedNum) || (Integer.MIN_VALUE > reversedNum)){
				reversedNum = 0;
				break;
			}
		}
		return (int)reversedNum;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
}