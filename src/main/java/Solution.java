import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //int[] A = {1, 3, 6, 4, 1, 2};
        int[] A = {-1, -3};
        int res = new Solution().solution(A);
        System.out.println("result " + res);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        Arrays.stream(A).forEach(System.out::println);
        int currValue = 0;
        int previousValue = 0;

        for (int i = 0; i < A.length; i++) {
            currValue = A[i];
            if (currValue < 0) {
                continue;
            }
            if ((currValue - previousValue)>1) {
                return previousValue + 1;
            }
            previousValue = A[i];
        }
        return previousValue +1;
    }
}
