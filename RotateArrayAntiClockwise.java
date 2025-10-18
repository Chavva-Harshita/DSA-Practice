import java.util.*;

public class RotateArrayAntiClockwise {
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateAnticlockwise(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);
        // Step 2: Reverse remaining elements
        reverse(arr, k, n - 1);
        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateAnticlockwise(arr, k);
        System.out.println("Anticlockwise Rotation by " + k + ": " + Arrays.toString(arr));
    }
}

