// https://planetcalc.com/1721/
class EditDistance {
	
	public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
	
	public static int min(int a,int b,int c) {
		int smallest = Math.min(a, Math.min(b, c));
		return smallest;
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
	                dp[i][j] = j;
	            }
	        	else if (j == 0) {
	                dp[i][j] = i;
	            }
	        	else {
	                dp[i][j] = min(dp[i - 1][j - 1] 
	                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
	                  dp[i - 1][j] + 1, 
	                  dp[i][j - 1] + 1);
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
		System.out.println(EditDistance.calculate("blended","noob"));
	}
}
