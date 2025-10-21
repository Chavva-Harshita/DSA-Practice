import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N (positive integer): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            sc.close();
            return;
        }

        int N = sc.nextInt();
        sc.close();

        if (N <= 0) {
            System.out.println("N should be a positive integer.");
            return;
        }

        List<String> binaries = generateBinary(N);

        System.out.println("Binary numbers from 1 to " + N + ":");
        // print them space-separated (same format as your example)
        for (int i = 0; i < binaries.size(); i++) {
            System.out.print(binaries.get(i));
            if (i < binaries.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static List<String> generateBinary(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 0; i < N; i++) {
            String current = q.poll(); // safe because queue is seeded and loop runs N times
            result.add(current);

            // enqueue next numbers
            q.add(current + "0");
            q.add(current + "1");
        }

        return result;
    }
}
