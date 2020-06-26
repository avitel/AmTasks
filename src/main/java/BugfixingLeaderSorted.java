import java.util.Arrays;

public class BugfixingLeaderSorted {
    public static void main(String[] args) {
        int[] A = {-1,3,-4,5,1,-6,2,1};
        int res = new BugfixingLeaderSorted().solution(A);
        System.out.println(res);
    }

    public int solution(int[] arr){
        int lenght = arr.length;
        long leftSum = 0;
        long rightSum = Arrays.stream(arr).sum() - arr[0];

        for (int i = 0; i < lenght; i++) {
            System.out.println("index " + i + " : value " + arr[i] + " left " + leftSum + " right " + rightSum);
            if (leftSum == rightSum){
                System.out.println(i);
            }
            if (i != lenght-1) {
                leftSum += arr[i];
                rightSum -= arr[i + 1];
            }
        }
        return -1;
    }


}
