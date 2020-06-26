import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2, 2, 2, 1, 1, 2};
        boolean res = new Solution1().solution(A);
        System.out.println("result " + res);
    }

    public boolean solution(int[] A) {
        int n = A.length;
        System.out.println("lenght "+n);
        int am1 = 0;
        int am2 = 0;
        int am3 = 0;
        int sum = Arrays.stream(A).sum();
        int am23 = sum - A[0];
        for (int d1 = 1; d1 <= (n-4) ; d1++) {
            am1 = am1 + A[d1-1];
            am23 = am23 - A[d1];
            am2 = 0;
            am3 = am23 - A[d1+1];
            for (int d2 = (d1+2); d2 <=(n-2) ; d2++) {
                am2 = am2 + A[d2-1];
                am3 = am3 - A[d2];
                System.out.println("d1 " +d1 +" d2 "+d2+ " am1 " +am1 +" am2 " +am2+ " am3 "+am3 + " am23 " +am23);

                if (am1 == am2 && am2 == am3) {
                    System.out.println("true " + am1 + " % " + d1 + " % " + d2);
                    return true;
                }
            }
        }
        return false;
    }
}

