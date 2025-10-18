import java.util.*;

public class RotateArrayClockwise {
    // Function to reverse part of array
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array by k positions (clockwise)
    static void rotateClockwise(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n case

        // Step 1: Reverse whole array
        reverse(arr, 0, n - 1);
        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);
        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateClockwise(arr, k);
        System.out.println("Clockwise Rotation by " + k + ": " + Arrays.toString(arr));
    }
}
