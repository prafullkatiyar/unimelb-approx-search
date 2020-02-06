// http://experiments.mostafa.io/public/needleman-wunsch/
class EditDistance {
	
	int match = 1;
	static int delete = -1;
	static int insert = -1;
	int replace = -1;
	
	public static int costOfSubstitution(char a, char b) {
        return a == b ? 1 : -1;
    }
	
	public static int max(int a,int b,int c) {
		int biggest = Math.max(a, Math.max(b, c));
		return biggest;
	}
	
	public static int calculate(String x, String y) {
		
		int[][] dp = new int[x.length() + 1][y.length() + 1];
		
		if(x.isEmpty()) {
			return y.length();
		}
		if (y.isEmpty()) {
            return x.length();
        } 
		
		for (int i = 0; i <= x.length(); i++) {
	        for (int j = 0; j <= y.length(); j++) {
	        	if (i == 0) {
	                dp[i][j] = j*(-1);
	            }
	        	else if (j == 0) {
	                dp[i][j] = i*(-1);
	            }
	        	else {
	                dp[i][j] = max(dp[i - 1][j - 1] 
	                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
	                  dp[i - 1][j] + delete, 
	                  dp[i][j - 1] + insert);
	            }
	        	
	        }
		}
		
	    return dp[x.length()][y.length()];
	}
}
public class Main {
	public static void main(String[] args)
	{
		//EditDistance obj = new EditDistance();
		System.out.println(EditDistance.calculate("condragulations","antidisestablishmentarianism"));
	}
}
