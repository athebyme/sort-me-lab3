import java.util.Arrays;
import java.util.Scanner;

class labH {
    static boolean check(int mid, int array[], int n, int K)
    {

        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > mid)
                return false;
            sum += array[i];
            if (sum > mid) {
                count++;
                sum = array[i];
            }
        }
        count++;
        if (count <= K)
            return true;
        return false;
    }


    static int solve(int array[], int n, int K)
    {
        int start = 1;
        for (int i = 0; i < n; ++i) {
            if (array[i] > start)
                start = array[i];
        }
        int end = 0;

        for (int i = 0; i < n; i++) {
            end += array[i];
        }

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid, array, n, K)) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner stdin =  new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt(), i = 0;
        int [] nums = new int [2*100001];
        stdin.nextLine();
        for (String a: stdin.nextLine().split(" ")){
            nums[i] = Integer.parseInt(a);
            i++;
        }
        int max = solve(nums,n,k), currentMax = 0, c = 0;
        i = 0;
        while((i < nums.length)&&(nums[i]!=0)){
            if((currentMax+nums[i] <= max)&&(c != k)){
                currentMax+=nums[i];
                i++;
            }else{
                c++;
                if(c + 1 != k) {
                    System.out.print(i + " ");
                    currentMax = 0;
                }
                else{
                    System.out.print(i);
                    break;
                }
            }

        }
    }
}
