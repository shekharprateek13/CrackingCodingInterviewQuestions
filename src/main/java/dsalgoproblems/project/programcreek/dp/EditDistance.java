package dsalgoproblems.project.programcreek.dp;

/**
 * @author shekh
 */
public class EditDistance {

	/*	def minEditDistance(target,source):
	    n = len(target)
	    m = len(source)
	    dist_matrix = np.zeros(shape=(n+1,m+1))
	    dist_matrix[0][0] = 0
	    for i in range(1, n):
	        dist_matrix[i,0] = dist_matrix[i-1,0] + 1
	    for j in range(1,m):
	        dist_matrix[0,j] = dist_matrix[0,j-1] + 1

	    for i in range(1, n+1):
	        for j in range(1, m+1):
	            row_dist = dist_matrix[i-1,j] + 1
	            col_dist = dist_matrix[i,j-1] + 1
	            offset = 0;
	            if target[i-1:i] == source[j-1:j]:
	                offset = 0
	            else:
	                offset = 2
	            diagonal_dist = dist_matrix[i-1,j-1] + offset
	            dist_matrix[i,j] = min(row_dist,col_dist,diagonal_dist)
	    print dist_matrix        
	    return dist_matrix[n,m];
	 */
	public static void displayMatrix(int[][] cache){
		for(int i = 0; i < cache.length; i++){
			for(int j = 0; j < cache[0].length; j++){
				System.out.print(cache[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	public static int getEditDistance(String s1, String s2){
		int m = s1.length();
		int n = s2.length();

		int[][] cache = new int[m+1][n+1];
		for(int i = 1; i < cache[0].length; i++){
			cache[0][i] = cache[0][i-1] + 1; 
		}

		for(int i = 1; i < cache.length; i++){
			cache[i][0] = cache[i-1][0] + 1; 
		}

		for(int i = 1; i <= m;i++){
			for(int j = 1; j <= n; j++){
				int row_dist = cache[i - 1][j] + 1;
				int col_dist = cache[i][j - 1] + 1;
				int diagonal_dist = -1;
				if(s1.charAt(i) == s2.charAt(j)){
					diagonal_dist = cache[i-1][j-1];
				}else{
					diagonal_dist = cache[i-1][j-1] + 2;
				}
				cache[i][j] = Math.min(row_dist, Math.min(col_dist, diagonal_dist));
			}
			displayMatrix(cache);
		}
		return cache[m][n];
	}

	public static void main(String[] args) {
		System.out.println(getEditDistance("intention","ntention"));
	}
}