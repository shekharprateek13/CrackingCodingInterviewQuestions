package project.euler;

/**
 * @author shekh
 */
public class LargestCollatzSequence {

	public LargestCollatzSequence() {
	}

	public static long nextCollatzSequence(long n){
		if(n%2==0){
			return n/2;
		}else{
			return 3*n+1;
		}
	}
	public static void main(String[] args) {
		int maxCollatzSequenceLength = 0;
		long maxCollatzSequenceTerm = 0;
		for(int i = 2; i < 1000000; i++){
			int count = 1;
			long nextTerm = i;
			while(nextTerm != 1){
				nextTerm = nextCollatzSequence(nextTerm);
				count++;
			}
			if(maxCollatzSequenceLength < count){
				maxCollatzSequenceLength = count;
				maxCollatzSequenceTerm = i;
			}
		}
		System.out.println("Max Collatz Sequence Term:"+maxCollatzSequenceTerm);
		System.out.println("Max Collatz Sequence Length:"+maxCollatzSequenceLength);
	}
}