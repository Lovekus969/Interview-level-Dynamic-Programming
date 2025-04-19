
public class LongestCommon{
        public static int longestCommonSubstring(String s1, String s2){
                //intialise 2 d array  first with some base case 
            int n = s1.length();
            int m = s2.length();
            int dp[][] = new int[n+1][m+1];
            for( int i=0 ; i< n+1; i++){//intialization 
                for( int j=0 ; j< m+1; j++){
                    if( i==0|| j==0){
                        dp[i][j] = 0;
                    }
                }
            } 
            int ans =0;
            //here goes the main code of substring 
            for( int i=1; i<n+1; i++){
                for(int j=1; j<m+1; j++){
                    if( s1.charAt(i-1)== s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                        ans =Math.max(ans, dp[i][j]);
                    }else{
                        dp[i][j]=0;//reset here if continuty brake it will say 0 reset back 

                    }
                  
                }
            }
            return ans ;
       }


        public static void main(String[] args) {
            String s1 = "ABCDE";
            String s2 = "ABGCE";
            System.out.println("Longest common Substring length is : = "+longestCommonSubstring(s1, s2));
        }
}