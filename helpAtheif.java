
// You have to help a thief to steal as many as GoldCoins as possible from a GoldMine. There he saw N Gold Boxes an each Gold Boxes consists of Ai Plates each plates consists of Bi Gold Coins. Your task is to print the maximum gold coins theif can steal if he can take a maximum of T plates.

 

// Example 1:

// Input:
// T = 3, N = 3 
// A[] = {1, 2, 3}
// B[] = {3, 2, 1}
// Output:
// 7
// Explanation:
// The thief will take 1 plate of coins
// from the first box and 2 plate of coins
// from the second plate. 3 + 2*2 = 7.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // Create a 2D array to store plates and corresponding gold coins
        int[][] arr = new int[N][2];
        
        // Fill the array with pairs of (A[i], B[i])
        for (int i = 0; i < N; i++) {
            arr[i][0] = A[i]; // Number of plates in this box
            arr[i][1] = B[i]; // Number of gold coins per plate in this box
        }
        
        // Sort by the number of gold coins per plate in descending order
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]); // Compare gold coins (B[i]) in reverse order
            }
        });
        
        int ans = 0; // Variable to store total gold coins stolen
        int platesTaken = 0; // Track how many plates we have taken so far
        
        // Iterate through the sorted array
        for (int i = 0; i < N && platesTaken < T; i++) {
            int platesToTake = Math.min(arr[i][0], T - platesTaken); // Take as many plates as possible from this box
            ans += platesToTake * arr[i][1]; // Multiply plates taken with the gold coins per plate
            platesTaken += platesToTake; // Update the total number of plates taken
        }
        
        return ans; // Return the maximum gold coins that can be stolen
    }

    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // Read the value of T (maximum plates) and N (number of boxes)
        int T = sc.nextInt();
        int N = sc.nextInt();
        
        // Initialize arrays A (number of plates per box) and B (gold coins per plate)
        int[] A = new int[N];
        int[] B = new int[N];
        
        // Read values for array A
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // Read values for array B
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        
        // Call the maxCoins function and print the result
        int result = maxCoins(A, B, T, N);
        System.out.println(result);
        sc.close();
    }
}
