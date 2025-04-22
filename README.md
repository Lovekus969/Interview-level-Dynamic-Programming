# Interview-level-Dynamic-Programming
Leveling up for interviews with some 🔥 DP skills – check my latest Java practice repo 💥
# 🚀 Dynamic Programming – Longest Common Substring in Java

This repository contains a clean and efficient solution for finding the **Longest Common Substring** between two strings using **Dynamic Programming** in Java.

## 💡 What’s Inside?
- 🧠 Dynamic Programming implementation
- 🧼 Clean code with clear comments
- ⚙️ Optimized for clarity and readability
we will focus on edit distance 
## 💥 Why This Matters?
Because problem-solving is not just about code — it's about **discipline, clarity, and consistency**.  
Every line here is a step toward mastering algorithms that power real-world tech.

. So lets move today towards Edit distance problem Let’s Visualize the DP Table
We’ll build a table with str1 as rows and str2 as columns.


                                                  i,j  ""	e	x	e	c	u	t	i	o	n
                                                 ""     0	1	2	3	4	5	6	7	8	9
                                                  i   1	1	2	3	4	5	6	6	7	8
                                                  n	    2	2	2	3	4	5	6	7	7	7
                                                  t	    3	3	3	3	4	5	5	6	7	8
                                                  e	    4	3	4	3	4	5	6	6	7	8
                                                  n	    5	4	4	4	4	5	6	7	7	7
                                                  t	    6	5	5	5	5	5	5	6	7	8
                                                  i	    7	6	6	6	6	6	6	5	6	7
                                                  o	    8	7	7	7	7	7	7	6	5	6
                                                  n	    9	8	8	8	8	8	8	7	6	5
 Final Answer = dp[9][9] = 5
Explanation:
We need 5 operations to convert intention → execution.

Operations could be:

Replace 'i' → 'e'

Replace 'n' → 'x'

Keep 't'

Keep 'e'

Keep 'n'

Keep 't'

Keep 'i'

Keep 'o'

Keep 'n'

You could also visualize the operations path by tracing back from dp[9][9] to dp[0][0].
Here is the code //
public class Edit {
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println("Min number of operations = " + editDistance(word1, word2));
    }
}
// Move up , move left, move diagonal and see minimum and then add1 to it thats how it goes in table .

