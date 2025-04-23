
public class WildCard{
    public static boolean isMatch(String s, String p){
        //talke the length function for both 
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];
        //step 1 initalise 
        dp[0][0]= true;
        // what if pattern is empty if so then string can be anything but always false 
        for( int i=1;i<n+1;i++){
               dp[i][0]= false;
          }//what is s=" "(Empty)
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                //cheack left index 
                dp[0][j] = dp[0][j-1];
            }
        } 
    //here bottom up apprch comes 
        for( int i=1; i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case 1 if ith ==jth ||or jth in pattern ==?
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    //cheack diagonally up 
                    dp[i][j]= dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    //cheack up or left and if any one of them true say true 
                    dp[i][j] = dp[i-1][j]|| dp[i][j-1];
                }else{
                    dp[i][j]= false;
                }
            }
        }
              return   dp[n][m];
    }
    

    public static void main(String [] args){
        String s = "abc";
        String p = "*****b";//true
        System.out.println("Is match "+ isMatch(s, p));
    }
}